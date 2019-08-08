import java.awt.*;

public class randomTests {
    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.BLACK);

        Spline test = new Spline();

        while (true) {
            test.add(new Point( Math.random() * width, Math.random() * height));
            StdDraw.clear();
            test.draw();
            StdDraw.show();
            StdDraw.pause(1000);
        }
    }
}
