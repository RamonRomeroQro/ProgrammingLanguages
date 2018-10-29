/*------------------------------------------------------------------------------

*

* Actividad de programación: Lenguajes de Programacion - Procesamiento Imagen

* Fecha: 29-Oct-2018

* Autor: A01700318 Ramon Romero

*

*-----------------------------------------------------------------------------*/

Compilation & Execution:

  $ cd Parallel/
  $ javac *.java
  $ java MainMulti ./images/Owl.jpg
  avg time = 12.60000
  $ java MainMulti ./images/zelda.jpg
  avg time = 14.00000
  $ cd ..
  $ cd Secuential/
  $ javac *.java
  $ java MainSingle ./images/Owl.jpg
  avg time = 15.80000
  $ java MainSingle ./images/zelda.jpg
  avg time = 20.30000


Results:

  S=speedup, Ts=time single processor, Tm= time multi processor.

  La evaluación promedio del caso Owl arrojó el siguiente speedup:
  S=Ts/Tp	S=15.8 ms/12.6 ms	S=1.25

  La evaluación promedio del caso zelda arrojó el siguiente speedup:
  S=Ts/Tp	S=20.3/ms14 ms	S=1.45


  Es evidente que el uso de Fork Join mejora mucho el procesamiento de la imagen,
  ya que fracciona de manera puntual el trabajo para cada procesador, adicional
  a esto es necesario puntualizar que la dimensión de la imagen juega un factor
  fundamental en el procesamiento.
