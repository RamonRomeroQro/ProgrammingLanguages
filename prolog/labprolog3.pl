% Lab 3 - Prolog 
% Daniel Jesús Amezcua Sánchez A01234223
% october 3rd, 2018

%%% LIMITED DEPTH FIRST %%%

% This limited depth first prolog program is based on the following depth first one :https://www.cs.unm.edu/~luger/ai-final/code/PROLOG.depth.html
% It is tested with a tree, but it also works with graphs since it records the visited nodes.
%start the search %
search(Start,Goal,Limit):-
	path(Start,Goal,[Start|[]],Limit).

% When the two first args are the same, it means it found the node, so the next thing to is print the path (the visited list reversed)
path(Goal,Goal, Visited,Limit):-
	print_reverse_list(Visited).
	
% If the two first args aren't the same, check for the path in the first child, if it founds the path, or if the max depth is reached, stop the search. 
path(Node,Goal,Visited, Limit):-
	NewLimit is Limit -1,
	NewLimit >= 0,
	child(Node,Child),
	
	%Check if we have already visited this node.
	%not_member(Child, Visited),
	add_visited(Child,Visited,New_Visited),

	%now begin the search in the child, if it eventually finds the goal, stop. Otherwise, it will go back and start again with a new child (if there are left)
	path(Child,Goal,New_Visited,NewLimit), !.

add_visited(Child,Visited,[Child|Visited]).

print_reverse_list([Head|[]]):-
	write(Head).

print_reverse_list([Head|Rest]):-
	print_reverse_list(Rest),
	write(Head).

not_member(X,[]).

not_member(X,[H|T]):-
 	X \= H,
 	not_member(X,T).
	
%%%				EXAMPLE TREE 		%%%
%					5
%				   / \
%				  2   1
%				 /   / \
%				3	7   9
%				   /			   
%			  	  10

child(5,2).
child(5,1).
child(2,3).
child(1,7).
child(1,9).
child(7,10).

%Example 1: should fail
%search(5,10,2).

%Example 2: should success
%search(5,10,4).


%% QUICKSORT %%

%The pivot is the first element
% Divide the list, then order the left side and the right side recursively. Return the list LeftListSorted, Pivot, RightListSorted
quick_sort([Pivot|List], ResultSorted):-
	divide(List, Pivot, LeftList,RightList),
	quick_sort(LeftList, LeftSorted),
	quick_sort(RightList, RightSorted),
	append_list(LeftSorted, [Pivot|RightSorted], ResultSorted),!.

%When the list to divide is empty, return an empty list.
quick_sort([],[]).

%If the first element N is less or equal to the pivot, append it to the left list, leave the RightList untouched.
divide([N|Rest], Pivot, [N|LeftList], RightList):-
	N =< Pivot,
	divide(Rest, Pivot, LeftList,RightList).

%Otherwise append the element N to the RightList, and left the LeftList untouched.
divide([N|Rest], Pivot, LeftList, [N|RightList]):-
	N > Pivot,
	divide(Rest, Pivot, LeftList,RightList).

%If the list to divide is empty, return RightList and LeftList as empty lists.
divide([], Pivot, [],[]).

append_list([N|Rest], List2, [N|Result]):-
	append_list(Rest, List2, Result).
	
append_list([], List2, List2).

%Examples
%quick_sort([1, 6, 2, 7], X).
%quick_sort([13, 46, 25, 12, 27, 1],  X).