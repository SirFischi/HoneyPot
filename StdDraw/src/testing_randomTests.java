import java.awt.*;

public class testing_randomTests {
    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.BLACK);

        drawObject_spline test = new drawObject_spline();

        while (true) {
            test.add(new drawObject_point( Math.random() * width, Math.random() * height));
            StdDraw.clear();
            test.draw();
            StdDraw.show();
            StdDraw.pause(1000);
        }
    }
}
