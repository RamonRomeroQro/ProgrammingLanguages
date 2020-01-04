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



/*

After this lab you should understand in what situations it is necessary to stop prologs backtracking and how to do so.
This is an implemented depth fist search algorithm in prolog:
https://www.cs.unm.edu/~luger/ai-final/code/PROLOG.depth.html
Read it carefully and use it as an example to implement your own Limited Depth First Search Algorithm





*/



/*

Implement the quicksort algorithm using prolog such that
?- quick_sort([1, 6, 2, 7], X).
X = [1, 2, 6, 7]
?- quick_sort ([1, 6, 2, 7], X).
X = [1, 2, 6, 7]
?- quick_sort ([13, 46, 25, 12, 27, 1],  X).
X = [1, 12, 13, 25, 27, 46]
 */




 quick_sort([P|List], ResultSorted):-
	divide(List, P, Left,Right),
	quick_sort(Left, LeftSorted),
	quick_sort(Right, RightSorted),
	append_list(LeftSorted, [P|RightSorted], ResultSorted),!.

quick_sort([],[]).

divide([N|Rest], P, [N|Left], Right):-
	N =< P,
	divide(Rest, P, Left,Right).

divide([N|Rest], P, Left, [N|Right]):-
	N > P,
	divide(Rest, P, Left,Right).

divide([], P, [],[]).

append_list([N|Rest], List2, [N|Result]):-
	append_list(Rest, List2, Result).
	
append_list([], List2, List2).