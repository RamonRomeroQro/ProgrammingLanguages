
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

import java.util.concurrent.RecursiveAction;

public class Yellow extends RecursiveAction {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final long MIN = 10;
    private final int src[], dest[], width, height, start, end;

    public Yellow(final int src[], final int dest[], final int width, final int height, final int start,
            final int end) {
        this.src = src;
        this.dest = dest;
        this.width = width;
        this.height = height;
        this.start = start;
        this.end = end;
    }

    private void clearify(final int ren, final int col) {

        int color = 0;
        final int rgb = this.src[(ren * width) + col];
        final int red = rgb & 0xFF;
        final int green = (rgb >> 8) & 0xFF;
        final int blue = (rgb >> 16) & 0xFF;
        final float L = (float) (0.2126 * (float) red + 0.7152 * (float) green + 0.0722 * (float) blue);
        color = 234 * (int) L / 255;
        color = (color << 8) | 176 * (int) L / 255;
        color = (color << 8) | 3 * (int) L / 255;
        dest[(ren * width) + col] = color;
    }

    public void computeDirectly() {
        int index;
        int ren, col;

        for (index = start; index < end; index++) {
            ren = index / width;
            col = index % width;
            clearify(ren, col);
        }
    }

    @Override
    protected void compute() {
        if ((this.end - this.start) <= Yellow.MIN) {
            computeDirectly();

        } else {
            final int middle = (end + start) / 2;

            invokeAll(new Yellow(src, dest, width, height, start, middle),
                    new Yellow(src, dest, width, height, middle, end));
        }
    }
}
