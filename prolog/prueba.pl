fibo(N,R):-
	N<1,
	R=0.

fibo(N,R):-
	N==1,
	R=1.

fibo(N,R):-
	N1 is N-1,
	N2 is N-2,
	fibo(N1,R1),
	fibo(N2,R2),
	R is R1+R2.

p([H|T], H, T).


callme([H|T], r):-
p([s,x,d], H, T),
r is H.

