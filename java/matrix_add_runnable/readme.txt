The solution can be implemented according to the size of the matrix,
by creating the threads one by one, like the commented section
ok with an thread pool, this implementation has a better escalability as it allows us to solve for
matrixs with size > 2.


Compile:
$ javac *.java
Execute:
$ java Test
