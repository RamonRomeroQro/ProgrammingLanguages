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

; After doing this lab you should be able to understand the basic structure
; of scheme and how to use its basic operators.

; Define the function triangle-area which receives the base and the
; height and returns the area of a triangle.


;;Formula triangle-area: (Base*Height)/2
;; Function definition

(define (triangleArea b h)
  (/ (* b h) 2 ) )


; Example for triangleArea 
(triangleArea 3 3)


; Define the functions a, b, and c that represent each of the following numerical statement respectively
; A) n2 + 10

(define (a n)
  (+ 10  (* n n))
  )

;Example for A)

(a 2)

; B) (1/2)*n2 + 20

(define (b n)
  (+ 20 (* .5 (* n n))))

;Example for B)

(b 10)


; C) 2 - (1/n)

(define (c n)
  (- 2 (/ 1 n)))

; Example for C) 

(c 2)

;The number of possible solutions of a quadratic equation depends on the values of a, b, and c.
;The possible number of solutions are dictated by the following rules  (We assume that x can’t be 0).

;two solutions if b2 > 4 · a · c,
;one solution if b2 = 4 · a · c, and
;no solution if b2 < 4 · a · c.

;Define the function solutions that receives a, b, and c and returns the number of possible solutions for a quadratic equation. 


(define (solutions a b c)
  (cond
   [(> (* b b) (* 4 a c)) 2]
   [(=(* b b) (* 4 a c)) 1]
   [(<(* b b) (* 4 a c)) 0]
   )
  )

(solutions 1 0 -1)
(solutions 2 4 2)
(solutions 4 0 2) 


  


