#!/bin/bash

cd Parallel/
javac *.java
echo "Ejecucion conversion Owl.jpg en paralelo, tiempo promedio 10 iteraciones"

java MainMulti ./images/Owl.jpg

echo "Ejecucion conversion zelda.jpg en paralelo, tiempo promedio 10 iteraciones"

java MainMulti ./images/zelda.jpg
rm -f *.class
cd ..
cd Secuential/
javac *.java
echo "Ejecucion conversion Owl.jpg en secuencial, tiempo promedio 10 iteraciones"

java MainSingle ./images/Owl.jpg
echo "Ejecucion conversion zelda.jpg en secuencial, tiempo promedio 10 iteraciones"

java MainSingle ./images/zelda.jpg
rm -f *.class
cd ..
