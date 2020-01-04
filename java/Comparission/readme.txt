This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.



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
