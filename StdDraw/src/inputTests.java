import java.awt.*;

public class inputTests {
    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.BLACK);

        drawObjects test = new drawObjects();

        while (true) {
            StdDraw.show();
            System.out.println(1);
            if (StdDraw.isMousePressed()) {
                Circle c = drawCircle(new Point(StdDraw.mouseX(), StdDraw.mouseY()));
                test.add(c);
            }
            test.draw();
        }
    }
    public static Circle drawCircle(Point middle) {
        Circle temp = new Circle(middle, 0.1);
        while (StdDraw.isMousePressed()) {
            temp.setRadius(middle.distance(new Point(StdDraw.mouseX(), StdDraw.mouseY())));
        }
        return temp;
    }
}
