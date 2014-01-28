-module(bookstore).
-export([server/1, client/3, start/0]).
server(State) -> server(State).
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
    register(bookus , Server).

spawnclients(Server , N)
->
    Vals = lists:map(fun(_) -> random:uniform(3) end,
		     lists:seq(1,N)),
    lists:map(fun(X) -> spawn(bookstore , client, [Server , X, random:uniform(5000)]) end,
              Vals).
