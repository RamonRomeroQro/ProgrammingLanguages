
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

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final int MAXTHREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String args[]) throws Exception {
        ForkJoinPool pool;

        if (args.length != 1) {
            System.out.println("usage: java Main image_file");
            System.exit(-1);
        }

        final String fileName = args[0];
        File srcFile = new File(fileName);
        final BufferedImage source = ImageIO.read(srcFile);

        int w = source.getWidth();
        int h = source.getHeight();
        int src[] = source.getRGB(0, 0, w, h, null, 0, w);
        int dest[] = new int[src.length];
        pool = new ForkJoinPool(MAXTHREADS);
        pool.invoke(new Yellow(src, dest, w, h, 0, src.length));
        final BufferedImage destination = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        destination.setRGB(0, 0, w, h, dest, 0, w);
        File outputfile = new File(fileName + "yellow.png");
        ImageIO.write(destination, "png", outputfile);

    }

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
}
