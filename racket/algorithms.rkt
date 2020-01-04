#lang racket


; This program is free software: you can redistribute it and/or modify
; it under the terms of the GNU General Public License as published by
; the Free Software Foundation, either version 3 of the License, or
; (at your option) any later version.
; This program is distributed in the hope that it will be useful,
; but WITHOUT ANY WARRANTY; without even the implied warranty of
; MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
; GNU General Public License for more details.
; You should have received a copy of the GNU General Public License
; along with this program.  If not, see <https://www.gnu.org/licenses/>.


;;Define function deep-all-x? which receives a list containing other lists (deep list) and an element x.
;;The function returns true if every single element in the list of lists is x. Otherwise it returns false.

(define (deep-all-x? tree number)
  (and
   (equal? (first tree) number) ;;Comparison with element--if one is false, everything becomes false
   (deep-nodes (rest tree) number)
   )	
)

;;Mutual recursion is defined
(define (deep-nodes tree number)
  (cond
    [(empty? tree) true]
    [else (and
           (deep-all-x? (first tree) number)
           (deep-nodes (rest tree) number);; keep looking
	)]
    )
)

;;test true
(define lista '(1(1 (1)(1)(1))(1 (1)(1))))
(deep-all-x? lista 1);;


;;test false
(define lista2 '(1(1 (6)(1)(1))(1 (1)(1))))
(deep-all-x? lista2 1);;




;;Define function deep-reverse which receives a deep list. The function returns a list of lists with its elements in reverse order.

;;we get append from prevous lab

(define (append list1 list2)
  (cond
      [(empty? list1) list2]  ;; after finish, add all and if empty
      [else (cons (first list1) (append (rest list1) list2))] ;;add to list
      )
)



(define (deep-reverse tree)
    (cond
      [(empty? tree) tree]
       [(list? (first tree)) (append (deep-reverse (rest tree)) (list (deep-reverse (first tree))))] ;; reverse list, list allows us to define if an element is a list
       [else (append (deep-reverse (rest tree)) (list (first tree)))] ;; reverse last elements
     )
  )



(deep-reverse '(a (b (c d)) e (f g))) ;;> ((g f) e ((d c) b) a)


;;Define function flatten that receives a deep list and return a list containing all the elements in a single 1 level list

(define (flatten tree)
    (cond
      [(empty? tree) tree]
      [(list? (first tree)) (append (flatten (first tree)) (flatten (rest tree)))];; If list go deep search, we use append from previous lab
      [else (cons (first tree) (flatten (rest tree)))];; join elements
      )
)



(flatten '(a (b (c d)) e (f g))) ;;> (a b c d e f g)



;;Define the function count-levels which counts the max depth of a tree




(define (get-greater a b)
  (cond
    [(>= a b) a]
    [else b]
    )
  );; define a function to get the greater or an element

(define (count-levels tree)
  (cond
    [(not (pair? tree))0]
    [(get-greater (+ 1 (count-levels (first tree))) ;; add 1
                  (count-levels (rest tree)))]    ;; and continue going down
    )
  )

(count-levels '(a(b (c) (d))(e (f) (g)))) ;;> 3

;;Define the function count-max-arity which counts the max number of children a single node of the tree has


(define (count-max-arity tree)
  (cond
    [(empty? tree) 0] ;; if no arity
    [else (count-arity-node tree 0)] ;; start looking 
    )
  )



(define (count-arity-node tree counter) ;; defining mutual recursion to keep looking

  (count-arity-deep (rest tree) counter)
)

(define (count-arity-deep tree counter)
  (cond
    [(empty? tree) counter]		
    [else  (get-greater (count-arity-node (first tree) 0) ;; check current node
                        (count-arity-deep (rest tree) (+ 1 counter)) ;; keep looking forn node and keep comparing
      )
     ]
		
    )
  )



(count-max-arity '( a (b (c) (d))  (e (f) (g) (h) (i))  )  ) ;; > 4






