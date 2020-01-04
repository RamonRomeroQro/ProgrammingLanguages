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


public class Addmat implements Runnable {

    int[][] mat1;
    int[][] mat2;
    int[][] mat3;

    int begin;
    int end;
    int index;

    public Addmat(int[][] m1, int[][] m2, int[][] m3, int b, int e, int i) {

        mat1 = m1;
        mat2 = m2;
        mat3 = m3;
        begin = b;
        end = e;
        index = i;

    }

    @Override

    public void run() {

        for (int j = 0; j < end; j++) {

            mat3[index][j] = mat1[index][j] + mat2[index][j] + mat3[index][j];

        }

    }

}
