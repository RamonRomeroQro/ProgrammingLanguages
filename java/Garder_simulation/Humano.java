
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

import java.util.Random;

public class Humano extends Thread {
	private Puerta oeste;
	private Puerta este;

	public Humano(Puerta oeste, Puerta este) {
		this.oeste = oeste;
		this.este = este;
	}

	public void run() {
		Random r = new Random();
		try {
			sleep(r.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (r.nextInt(2) == 0) {
			oeste.entra(este);
		} else {
			este.entra(oeste);
		}
		try {
			sleep(r.nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		oeste.current(este);
		if (r.nextInt(2) == 0) {
			oeste.sale(este);
		} else {
			este.sale(oeste);
		}

	}
}
