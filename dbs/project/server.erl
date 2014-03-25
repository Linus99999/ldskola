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
    StorePid = spawn_link(fun() -> store_loop(ServerPid,Initialvals, Initialvals) end),
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
	{request, Client, X} -> %% proceed/close sends back to the client -- add concurrency control
	    case ClientPid of
		0 ->
		    Client ! {proceed, self()},
		    io:format("Client~p recieved permission to start transaction~n", [Client]),
		    server_loop(ClientList,StorePid, Client, X);
		_ ->
		    Client ! {busy, self()},
		    server_loop(ClientList,StorePid, ClientPid, Count)
	    end;
	{confirm, Client} -> %% sent after all actions. abort, committed, close, 'EXIT'?  
	    case Count of
		0 ->
		    Client ! {committed, self()},
		    StorePid ! {commit, self()},
		    StorePid ! {print, self()},
		    server_loop(ClientList,StorePid, 0, -1);
		_ -> 
		    Client ! {abort, self()},
		    StorePid ! {revert, self()},
		    server_loop(ClientList, StorePid, 0, -1)
	    end;
	{action, Client, Act} -> %% gets multiple messages if the client has alot of writes/reads  
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
store_loop(ServerPid, Database, TransDb) -> 
    receive
	{print, ServerPid} -> 
	    io:format("Database status:~n~p.~n",[Database]),
	    store_loop(ServerPid,Database, TransDb);
	{store, Act} ->
	    case element(1, Act) of
		write ->
		    Tuple = {element(2,Act), element(3,Act)},
		    NewDatabase = lists:keyreplace(element(1, Tuple), 1, TransDb, Tuple),
		   
		    store_loop(ServerPid, Database, NewDatabase);
		read ->
		  %%  Client ! {
		    store_loop(ServerPid, Database, TransDb)
	    end;
	{commit, ServerPid} -> store_loop(ServerPid, TransDb, TransDb);
	{revert, ServerPid} -> store_loop(ServerPid, Database, Database)
    end.
%%%%%%%%%%%%%%%%%%%%%%% ACTIVE SERVER %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%



%% - Low level function to handle lists
add_client(C,T) -> [C|T].

remove_client(_,[]) -> [];
remove_client(C, [C|T]) -> T;
remove_client(C, [H|T]) -> [H|remove_client(C,T)].

all_gone([]) -> true;
all_gone(_) -> false.
