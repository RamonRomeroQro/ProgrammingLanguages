

import java.util.concurrent.RecursiveAction;

public class Yellow extends RecursiveAction {
    private static final long MIN = 10;
    private int src[], dest[], width, height, start, end;

    public Yellow(int src[], int dest[], int width, int height, int start, int end) {
        this.src = src;
        this.dest = dest;
        this.width = width;
        this.height = height;
        this.start = start;
        this.end = end;
    }




        private void clearify(int ren, int col) {

            int color=0;
            int rgb=this.src[(ren * width) + col];
            int red = rgb & 0xFF;
            int green = (rgb >> 8)& 0xFF;
            int blue = (rgb >> 16)& 0xFF;
            float L = (float) (0.2126*(float)red + 0.7152* (float) green + 0.0722* (float) blue);
            color = 234 * (int) L/255;
            color = (color<< 8) | 176 * (int) L/255;
            color = (color<< 8) | 3 * (int) L/255;
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
        if ( (this.end - this.start) <= Yellow.MIN ) {
            computeDirectly();

        } else {
            int middle = (end + start) / 2;

            invokeAll(new Yellow(src, dest, width, height, start, middle),
                    new Yellow(src, dest, width, height, middle, end));
        }
    }
}
