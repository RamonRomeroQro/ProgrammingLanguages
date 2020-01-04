
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

public class Puerta {
	private int adentro;
	private int afuera;
	private int lado;

	public Puerta(int a) {
		this.adentro = 0;
		this.afuera = 0;
		this.lado = a;
	}

	public synchronized void entra(Puerta aux) {
		this.adentro++;
		if (this.lado == 0) {
			System.out.println("Persona llega por puera Oeste");
		} else {
			System.out.println("Persona llega por puerta Este");
		}
	}

	public synchronized void sale(Puerta aux) {
		this.afuera++;
		if (this.lado == 0) {
			System.out.println("Persona sale por puerta Oeste");
		} else {
			System.out.println("Persona sale por puera Este");
		}
	}

	public synchronized int cantidad() {
		return this.adentro - this.afuera;
	}

	public void current(Puerta otra) {
		System.out.println("Cantidad de Personas en el Interior del Jardin: " + (otra.cantidad() + this.cantidad()));
	}
}
