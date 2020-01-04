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

public class MainMulti {
	private static final int MAXTHREADS = Runtime.getRuntime().availableProcessors();

	public static void main(String args[]) throws Exception {
		ForkJoinPool pool;
		long startTime, stopTime;
		double acum = 0;

		if (args.length != 1) {
			System.out.println("usage: java MainMulti image_file");
			System.exit(-1);
		}

		final String fileName = args[0];
		File srcFile = new File(fileName);
		final BufferedImage source = ImageIO.read(srcFile);

		int w = source.getWidth();
		int h = source.getHeight();
		int src[] = source.getRGB(0, 0, w, h, null, 0, w);
		int dest[] = new int[src.length];

		acum = 0;
		for (int j = 1; j <= Utils.N; j++) {
			startTime = System.currentTimeMillis();

			pool = new ForkJoinPool(MAXTHREADS);
			pool.invoke(new ForkGray(src, dest, w, h, 0, src.length));

			stopTime = System.currentTimeMillis();
			acum += (stopTime - startTime);
		}
		System.out.printf("avg time = %.5f\n", (acum / Utils.N));

		final BufferedImage destination = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		destination.setRGB(0, 0, w, h, dest, 0, w);

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ImageFrame.showImage("Original - " + fileName, source);
			}
		});

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ImageFrame.showImage("Gray - " + fileName, destination);
			}
		});
	}
}
