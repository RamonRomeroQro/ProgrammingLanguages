
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.

public class Jardin {
	public static void main(String args[]) {
		int personasInside;
		Puerta oeste = new Puerta(1);
		Puerta este = new Puerta(0);
		// cada humano es un thread
		int tHumanos = 10;
		Humano threads[] = new Humano[tHumanos];
		for (int i = 0; i < tHumanos; i++) {
			threads[i] = new Humano(oeste, este);
		}
		System.out.println("\n\nHay " + tHumanos + " personas esperando");
		System.out.println("El jardin abre..");
		personasInside = oeste.cantidad() + este.cantidad();
		System.out.println("Cantidad de Personas en el Interior del Jardin: " + personasInside);
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
		System.out.println("\nCantidad de Personas en el Interior del Jardin: " + personasInside + "\n");

	}
}
