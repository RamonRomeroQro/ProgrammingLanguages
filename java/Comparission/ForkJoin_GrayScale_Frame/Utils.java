
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

public class Utils {
	private static final int DISPLAY = 100;
	private static final int MAX_VALUE = 10_000;
	private static final Random r = new Random();
	public static final int N = 10;

	public static void randomArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(MAX_VALUE) + 1;
		}
	}

	public static void fillArray(int array[]) {
		for (int i = 0; i < array.length; i++) {
			array[i] = (i % MAX_VALUE) + 1;
		}
	}

	public static void displayArray(String text, int array[]) {
		System.out.printf("%s = [%4d", text, array[0]);
		for (int i = 1; i < DISPLAY; i++) {
			System.out.printf(",%4d", array[i]);
		}
		System.out.printf(", ..., ]\n");
	}
}
