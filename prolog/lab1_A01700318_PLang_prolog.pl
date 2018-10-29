/* 
*	
* José Ramón Romero Chávez 
* A01700318
* 
*	Lab 1 - Prolog
* 	After doing this lab you should be able to understand how to represent facts and 
*	graphs in a logic programming language.
*	You should also grasp how Prolog’s basic operations work.
*	
*	Given the following facts:
*/


hobby(juan,kaggle). 
hobby(luis,hack). 
hobby(elena,tennis). 
hobby(midori,videogame). 
hobby(simon,sail).
hobby(simon,kaggle).
hobby(laura,hack).
hobby(hans,videogame). 


/*Define a predicate “compatible(X,Y)”.
We say that X and Y are compatible
if they share at least 1 hobby.*/

compatible(X,Y):-
hobby(X,Z),
hobby(Y,Z).


/*Use the following map to generate a KB of the paths
that lead to Rome (ROMA!), assume that every road is a one way
road and the all lead to the capital, because 

	“all roads lead to Rome”. 

The directions in your predicates should be from left (start) to right (end). */

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

/* Define the predicate

	min(A, B, C, Z)
	
Which returns Z as the minimal value between A, B, and C.
*/


min(A, B, C, Z):-

A=<B, A=<C , Z = A;
B=<A, B=<C , Z = B;
C=<A, C=<B , Z = C.

/* Define the predicate:

	gcd(A, B, Z)

which returns Z as the greatest common divisor (or highest common factor) of A and B.


*/




gcd(A, B, Z) :-
B==0,
Z is 1;
A==0,
Z is 1.



gcd(A, B, Z) :-
A < 0,
N is A * -1,
gcd(N, B, Z).

gcd(A, B, Z) :-
B < 0,
N is B * -1,

gcd(A, N, Z).
    
    
gcd(A,B,Z) :-
A==B, Z=A.

gcd(A,B,Z) :-
A<B, N is B-A,
gcd(A,N,Z).

gcd(A,B,Z) :-
A>B,
gcd(B,A,Z).



