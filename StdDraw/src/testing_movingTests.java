import java.awt.*;

public class testing_movingTests {
    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.BLACK);

        drawObject_list test = new drawObject_list();
        drawObject_list test2 = new drawObject_list();
        test.add(new drawObject_line(0, 0, 0, height));
        test2.add(new drawObject_line(0, height, width, height));
        while (true) {
            StdDraw.clear();
            test.draw();
            test2.draw();
            StdDraw.show();
            test.move(1, 0);
            test2.move(0, -0.5);
            StdDraw.pause(10);
        }
    }
}
