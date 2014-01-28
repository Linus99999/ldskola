-module(bookstore).
-export([server/1, client/3, start/0]).
server(State) -> 
    receive 
	{add, Book, Author, Price, Qty} ->
	    case lists:keysearch(Book, 1, State) of
		false -> StateNew = [{Book, Author,Price, Qty}|State],
			 io:fwrite("~p has been added to our inventory ~n", [Book]),
			 server(StateNew);
		_-> server(State) %% shouldn't we add quantity here?
	    end;
	{buy, Book, Pid} ->
	    case lists:keysearch(Book,1, State) of
		false -> io:fwrite("buy request from ~p ~n Sorry ~p, we don't have ~p",[Pid,Pid, Book]),
			 server(State);
		{_,Tuple} -> case element(4,Tuple) of
				 0 -> io:fwrite("buy request from ~p ~n Sorry ~p, ~p is sold out",[Pid,Pid, Book]),
				      server(State);
				 _ -> StateNew = lists:keyreplace(Book, 1, State,setelement(4,Tuple, element(4,Tuple) -1)),
				      io:fwrite("buy request from ~p ~n Client ~p bought a copy of ~p", [Pid,Pid,Book]),
				      io:format("new inventory: "),
				      lists:map(fun(X) -> io:format("~p~n",[X]) end, StateNew),
				      server(StateNew)
			     end
	    end;
	{close} -> io:format("closed for today!"),
		   exit(normal);
	_ -> io:fwrite("What is this witch-craft?!"),
	     server(State)
		       
    end.

	
    %Bookus = whereis(bookus),
    %io:fwrite("~p ~n", [Bookus]). 

client(Server , X, Wait) ->
    timer:sleep(Wait),
      case X of
	  1 -> Server ! {buy,"Dune",self()};
	  2 -> Server ! {buy,"Excession",self()};
	  3 -> Server ! {buy,"The Forever War",self()}
end.
start() -> 
    Server = spawn(bookstore , server, [[]]),
    %% Server ! {add, Name, Author, Price, Quantity}
    Server ! {add, "Dune", "Frank Herbert", 150, 10},
    Server ! {add, "Excession", "Iain M. Banks", 300, 2},
    Server ! {add, "The Forever War", "Joe Haldeman", 170, 3},
    register(bookus , Server),
    spawnclients(Server , 4).
    

spawnclients(Server , N)->
    
    Vals = lists:map(fun(_) -> random:uniform(3) end,
		     lists:seq(1,N)),
    lists:map(fun(X) -> spawn(bookstore , client, [Server , X, random:uniform(5000)]) end,
              Vals).
