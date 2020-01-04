% This program is free software: you can redistribute it and/or modify
% it under the terms of the GNU General Public License as published by
% the Free Software Foundation, either version 3 of the License, or
% (at your option) any later version.
% This program is distributed in the hope that it will be useful,
% but WITHOUT ANY WARRANTY; without even the implied warranty of
% MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
% GNU General Public License for more details.
% You should have received a copy of the GNU General Public License
% along with this program.  If not, see <https://www.gnu.org/licenses/>.

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

