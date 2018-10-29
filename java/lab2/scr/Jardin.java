/*

  Jose Ramon Romero Chavez
  A01700318
  Lenguajes Lab2 Java

*/

public class Jardin {
	public static void main(String args[]) {
		int personasInside;
		Puerta oeste = new Puerta(1);
		Puerta este = new Puerta(0);
    //cada humano es un thread
    int tHumanos=10;
		Humano threads[] = new Humano[tHumanos];
		for (int i = 0; i < tHumanos; i++) {
			threads[i] = new Humano(oeste, este);
		}
		System.out.println("\n\nHay "+ tHumanos + " personas esperando");
    System.out.println("El jardin abre..");
		personasInside = oeste.cantidad() + este.cantidad();
		System.out.println("Cantidad de Personas en el Interior del Jardin: "+personasInside);
		for (int i = 0; i < tHumanos; i++) {
			threads[i].start();
		}
		for (int i = 0; i < tHumanos; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		personasInside = oeste.cantidad() + este.cantidad();
		System.out.println("\n\nEl jardin ha cerrado!");
    System.out.println("\nCantidad de Personas en el Interior del Jardin: " + personasInside+ "\n");

	}
}
