
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.concurrent.ForkJoinPool;

public class Main {
	private static final int MAXTHREADS = Runtime.getRuntime().availableProcessors();

	public static void main(String args[]) throws Exception {
		ForkJoinPool pool;
		long startTime, stopTime;
		double acum = 0;

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
			pool.invoke(new ForkGray(src, dest, w, h, 0, src.length));
		final BufferedImage destination = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		destination.setRGB(0, 0, w, h, dest, 0, w);
		File outputfile = new File(fileName+"gray.png");
		ImageIO.write(destination, "png", outputfile);


	}
}
