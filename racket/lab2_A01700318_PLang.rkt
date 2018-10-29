#lang racket

;;José Ramón Romero
;;A01700318 lab2

;;After doing this lab you should be able to manipulate lists and use both tail and head recursion




;;Define the functions power-head and power-tail.
;;The functions much calculate the power of the given number.
;;The difference is that power-head should use head recursion and power-tail should use tail recursion.
;;> (power-head 4 3) should return 64



(define (power-head  a b)
   (cond
     [(= b 1) a]
     [else (* a (power-head a (- b 1) ))]
   )
)
  
   
(power-head 4 3) ;64





;;> (power-tail 4 3) should return 64







(define (insider-power-tail a b i)
  (cond
    [(<= b 0) i]
    [else (insider-power-tail a (- b 1) (* i a))] 
  )
)


(define (power-tail a b)
  (insider-power-tail a b 1)
  )





(power-tail 4 3);; 64







;;Define the function third which returns the third element of a list.


(define (third numbers)
    (insider-third numbers 1)
)
  
(define (insider-third numbers i)
  (cond
    [(empty? numbers) false]
    [(= i 3) (first numbers)]
    [else (insider-third (rest numbers) (+ i 1))] 
))




(third (cons 1(cons 2 (cons 3 (cons 4 (cons 5 empty)))))) ;should return 3



;;Define function just-two? Which returns true if a list contains only two elements



(define ( just-two? numbers)
  ( insider-just-two? numbers 0)
 )



(define (insider-just-two? numbers i)
  (cond


      [(and ( empty? numbers) ( = i 2)  ) true]
      [(and (empty? numbers) (or (< i 2) (> i 2)))false]
      [else  (insider-just-two? (rest numbers) (+ i 1)) ]
  
  )
)




(just-two? (cons 1 empty))   ;; #f
(just-two? (cons 1 (cons 4 empty))) ;;  #t



;;Define the function how-many-x? that receives a list and should return the number of elements that match x




(define ( how-many-x? list number)
  ( insider-how-many-x? list number  0)
  )



(define (insider-how-many-x? list number matches)
  (cond

   [(empty? list) matches]
   [(= (first list) number) (insider-how-many-x? (rest list) number (+ matches 1))]
   [else (insider-how-many-x? (rest list) number matches)]


    
  )
)


(define list (cons 1(cons 2 (cons 3 (cons 4 (cons 3 empty))))))

(how-many-x? list 3)  ;2




;;Define the function all-x? that returns true if every element of the list is x


(define ( all-x? list number)
  ( insider-all-x? list number false)
 )



(define (insider-all-x? list number flag)
  (cond
   [(empty? list) true]
   [(equal? flag false) flag]
   [(= first list number) (insider-all-x? (rest list) number true)]
   [else (insider-all-x? (rest  list) number false)]

   )
)



(define list3 (cons 3(cons 3 (cons 3 (cons 2 (cons 2 empty))))))

(all-x? list3 3)  ;F






;;Define the function get which receives a list and a position and returns the value in that position of the list.



(define (get list number)
  (insider-get list number 1)
)

(define (insider-get list number counter)
  (cond
    [(empty? list) false]
    [(= number counter) (first list)]
    [else (insider-get (rest list) number (+ counter 1))]
  )
)


(define lista3 (cons 1(cons 2 (cons 3 (cons 4 (cons 3 empty))))))
(get lista3 2) ;; 2
 (get lista3 5) ;; 3



;;Define the function difference that receives 2 lists A and B. The function must return a new list that contains the elements in A that re not present in B. E.g.:


(define (difference list1 list2)
  (cond
    [(empty? list1) empty]
    [(= (how-many-x? list2 (first list1)) 0) (cons (first list1) (difference (rest list1) list2))] ;; compares the list to evaluate which are not in the other list
    [else (difference (rest list1) list2)]
   )
)


(difference '(12 44 55 77 66 1 2 3 4) '(1 2 3))  ;;'(4 66 77 55 44 12)



;;Define the function append that receives 2 lists A and B. The function return only 1 list with the elements of A followed by the elements of B.


(define (append list1 list2)
  (cond
      [(empty? list1) list2]  ;; after finish, add all and if empty
      [else (cons (first list1) (append (rest list1) list2))]
      )
)

(append '(a b c d) '(e f g))  ;;(a b c d e f g)
(append  '( ) '(a b c))  ;;(a b c)



;;Define the function invert which inverts the order of the elements in a list



(define (invert list)
  (cond
    [(empty? list) empty] ;; empty list
    [else (new-list(invert(rest list))(first list))]
    )
)


(define (new-list list x)
  (cond
    [(empty? list) (cons x empty)]
    [else (cons (first list) (new-list (rest list) x))]
  )
)
(invert '(a b c d))  ;;(d c b a)
(invert '( )) ;;( )


;;Define the function sign that receives a list of numbers and returns a list of 1 or -1 depending on whether each number is greater or lesser than 0.


(define (sign list)
  (cond
    [(empty? list) empty]
    [else (cons (eval (first list)) (sign (rest list)))]
  )
)

(define (eval number)
  (cond
  [(> number 0) 1]
    [(< number 0) -1]
  )
)
(sign '(2 -4 -6));;(1 -1 -1)


;;Define the function negatives that receives a list of positive numbers and returns a list with the corresponding negative numbers.

(define (negatives list)
  (cond
          [(empty? list) empty]
          [else (cons (toNegative (first list)) (negatives (rest list))) ]
  )
)

(define (toNegative number)
  (cond
    [(> number 0) (* -1 number)]
    [else number]
    )
)



 (negatives '(2 -4 6));; (-2 -4 -6)



