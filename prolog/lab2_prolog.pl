/*
	Jose Ramon Romero Chavez
	Prolog Lab 2
*/






/*
	After this lab you should have a deeper understanding of recursion,
	and you should know how lists work in Prolog.
	Define the following predicates:
	
	
	Any positive.
	
	any_positive([-1,-2,3,-4]).
	true.

*/

any_positive([]):-
	false.
	

any_positive([H|T]):-
	H<0, any_positive(T).
	
any_positive([H|T]):-
	H>0, !.



/*	
	Substitute.
	substitute(2, 3, [1, 2, 2, 2, 3, 2], X).	
	X = [1, 3, 3, 3, 3, 3]
	
*/




substitute(N,M,[],[]).

substitute(N,M,[N|T],[M|R]):-
	substitute(N,M,T,R).

substitute(N,M,[X|T],[X|R]):-
	X =\= N,
	substitute(N,M,T,R).
	
	


/*	

	Eiminate duplicates.
	eliminate_duplicates ([a, a, a, a, b, c, c, a, a, d, e, e, e, e],X).
	X = [a, b, c, d, e]
	
*/

eliminate_duplicates([],[]).	
	
eliminate_duplicates([H|T], [H|R]):-
	\+ (member(H,T)),
	eliminate_duplicates(T,R).
eliminate_duplicates([X|T], R):-
	eliminate_duplicates(T,R).

	

/*
	Intersect.
	intersect ([a, b, c, d], [b, d, e, f], X).
	X = [b, d]
*/



intersect([],L2,[]).

intersect([H|T],L2, [H|R]):-
	member(H,X2),
	intersect(T,L2,R).
	
	
intersect([H|T],L2, R):-
	intersect(T,L2,R).



/*
	Invert.
	invert([a, b, e, c, e],X).
	X = [e, c, e, b, a]
*/

invert([], []).
invert([H|T],Z) :-
    invert(T,Z1),
    append(Z1, [H], Z).



/*
	Less than.
	less_than(5, [1, 6, 5, 2, 7], X).
	X = [1, 2]
*/



less_than(N,[],[]).
less_than(N,[X|T],[X|R]):- 
	X < N,
	less_than(N,T,R).

less_than(N,[X|T],R):-
	less_than(N,T,R).




/*
	More than (or equal).
	more_than((5, [1, 6, 5, 2, 7], X).
	X = [6, 5, 7]
*/


more_than(N,[],[]).
more_than(N,[X|T],[X|R]):- 
	X >= N,
	more_than(N,T,R).

more_than(N,[X|T],R):-
	more_than(N,T,R).





/*	rotate.
	rotate([1, 6, 5, 2, 7], 3, X).
	X = [2, 7, 1, 6, 5]
	
	rotate([1, 6, 5, 2, 7], -3, X).
	X = [5, 2, 7, 1, 6]
*/



rotate(L1, N, L2) :-
    N < 0, !,
    N1 is -N,
    rotate(L2, N1, L1).
    
rotate(L1, N, L2) :- 
    append(A, B, L1),
    append(B, A, L2), 
    length(A, N).  





/*

	Given the Italy Knowledge base you used in the last lab,
	modify it so that the relations between part are bidirectional.
	
	Define the predicate path(Origin, Destiny, Path)
	which returns in Path the path between Origin and Destiny.
	+ 10 points in lab if the path is the shortest possible one.


*/


connects( genua, placentia). 
connects( genua, pisae).
connects( genua, roma). 
connects( pisae, roma). 
connects( placentia, ariminum). 
connects( ariminum, roma). 
connects( ariminum, ancona). 
connects( ancona, roma). 
connects( ancona, castrumtruentinum). 
connects( castrumtruentinum, roma). 
connects( brundisium , capua). 
connects( capua , roma). 
connects( rhegium , capua). 
connects( messana, rhegium ). 
connects( catina, messana ). 
connects( syracusae, catina ). 
connects( lilibeum, messana ). 

/* Define the rule

	can_get_to(Origin, Destination).
	
which is true if there is a path that starts in Origin and following
the directionality of the roads can get to Destination

Example: 
can_get_to(lilibeum, capua)  is true, 
can_get_to(roma, pisae)  is false.
*/





can_get_to(O,D):-
connects( O, D ).


can_get_to(O,D):-
connects( O, Y ),
can_get_to(Y,D).



/* Define the predicate:

	size(X, Y, Z).
	
which returns in Z the number of cities crossed in the path from X to Y,
the optimal path is not required, yet.
*/

size(X, Y, Z):-
conta( X, Y, 0, R ),
Z=R.


conta(X,Y, C, R):-
connects( X, Y ), 
R is C+1;

C2= C+1,
connects(X, Q ),
conta(Q,Y, C2, R ).







