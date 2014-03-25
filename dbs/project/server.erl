%% Created by: Linus Östrén, David Rönn Jansson

%% - Server module
%% - The server module creates a parallel registered process by spawning a process which 
%% evaluates initialize(). 
%% The function initialize() does the following: 
%%      1/ It makes the current process as a system process in order to trap exit.
%%      2/ It creates a process evaluating the store_loop() function.
%%      4/ It executes the server_loop() function.

-module(server).

-export([start/0]).

%%%%%%%%%%%%%%%%%%%%%%% STARTING SERVER %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
start() -> 
    register(transaction_server, spawn(fun() ->
					       process_flag(trap_exit, true),
					       Val= (catch initialize()),
					       io:format("Server terminated with:~p~n",[Val])
				       end)).

initialize() ->
    process_flag(trap_exit, true),
    Initialvals = [{a,0},{b,0},{c,0},{d,0}], %% All variables are set to 0
    ServerPid = self(),
    StorePid = spawn_link(fun() -> store_loop(ServerPid,Initialvals, Initialvals, []) end),
    server_loop([],StorePid, 0, -1).
%%%%%%%%%%%%%%%%%%%%%%% STARTING SERVER %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


%%%%%%%%%%%%%%%%%%%%%%% ACTIVE SERVER %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%% - The server maintains a list of all connected clients and a store holding
%% the values of the global variable a, b, c and d 
server_loop(ClientList,StorePid, ClientPid, Count) ->
    receive
	{login, MM, Client} -> 
	    MM ! {ok, self()},
	    io:format("New client has joined the server:~p.~n", [Client]),
	    StorePid ! {print, self()},
	    server_loop(add_client(Client,ClientList),StorePid, ClientPid, Count);
	{close, Client} -> 
	    io:format("Client~p has left the server.~n", [Client]),
	    StorePid ! {print, self()},
	    server_loop(remove_client(Client,ClientList),StorePid, ClientPid, Count);
	{request, Client, X} -> %% Receives a transaction-request from the client, containing the amount X of transaction-steps to do.
	    case ClientPid of %% Checks if there is a transaction in progress and sends a busy message if there is, sends a proceed message otherwise.
		0 ->
		    Client ! {proceed, self()},
		    io:format("Client~p recieved permission to start transaction~n", [Client]),
		    server_loop(ClientList,StorePid, Client, X);
		_ ->
		    Client ! {busy, self()},
		    server_loop(ClientList,StorePid, ClientPid, Count)
	    end;
	{confirm, Client} -> %% The client asks if everything went ok and gets either a abort message or that everything went fine and got committed.
	    case Count of
		0 ->
		    StorePid ! {commit, self()},
		    receive 
			{reads, List} ->
			    Client ! {committed, self(), List}, %% Sends a committed message to the client containing the list of every read requested and the server pid.
			    StorePid ! {print, self()},
			    server_loop(ClientList,StorePid, 0, -1);
			_ ->
			    io:format("error")
		    after 2000 -> server_loop(ClientList, StorePid, 0, -1) %% redundant since we don't have to care about crashes, but to prevent deadlock.
		    end;
		_ -> 
		    Client ! {abort, self()},
		    StorePid ! {revert, self()},
		    server_loop(ClientList, StorePid, 0, -1)
	    end;
	{action, Client, Act} -> %% Receives a transaction-step from the client with instructions and passes it onwards to the store_loop, decreases count by one. 
	    io:format("Received~p from client~p.~n", [Act, Client]),
	    StorePid ! {store, Act},
	    server_loop(ClientList,StorePid, ClientPid, Count-1)
    after 50000 ->
	    case all_gone(ClientList) of
		true -> exit(normal);    
		false -> server_loop(ClientList,StorePid, ClientPid, Count)
	    end
    end.

%% - The values are maintained here
store_loop(ServerPid, Database, TransDb, Reads) -> 
    receive
	{print, ServerPid} -> 
	    io:format("Database status:~n~p.~n",[Database]),
	    store_loop(ServerPid,Database, TransDb, Reads);
	{store, Act} -> %% Stores each write inside the transaction-database to be able to recover from a lost message or a crash.
	    case element(1, Act) of
		write ->
		    Tuple = {element(2,Act), element(3,Act)},
		    NewDatabase = lists:keyreplace(element(1, Tuple), 1, TransDb, Tuple), %% replaces current values with a new written value.

		    store_loop(ServerPid, Database, NewDatabase, Reads);
		read -> %% When it receives a read, it will read the database as it is during the transaction, and only return the reads if the transaction was successfull.
		    store_loop(ServerPid, Database, TransDb,[lists:keyfind(element(2,Act), 1, TransDb)|Reads])
	    end;
	{commit, ServerPid} -> %% if everything went fine, we'll committ and use the TransDb as our new database.
	    ServerPid ! {reads, lists:reverse(Reads)},
	    store_loop(ServerPid, TransDb, TransDb, []); 
	{revert, ServerPid} -> store_loop(ServerPid, Database, Database, []) %% revert changes if something got lost in the transaction.
    end.
%%%%%%%%%%%%%%%%%%%%%%% ACTIVE SERVER %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%



%% - Low level function to handle lists
add_client(C,T) -> [C|T].

remove_client(_,[]) -> [];
remove_client(C, [C|T]) -> T;
remove_client(C, [H|T]) -> [H|remove_client(C,T)].

all_gone([]) -> true;
all_gone(_) -> false.
