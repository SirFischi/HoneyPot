import java.awt.*;

public class basicTests {

    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.BLACK);

        drawObjects test = new drawObjects();
        test.add(new Point(200, 200));
        test.add(new Line(0, 0, 100, 100));
        test.add(new Circle(new Point(300, 300), 50));
        test.add(new Rectangle(new Point(200, 300), 30, 60));
        test.add(new Square(new Point(300, 50), 30));
        test.fill();
        StdDraw.show();
        System.out.println(test);
        StdDraw.pause(1000);
        System.out.println("------------------------");
        test.move( 30, 30);
        StdDraw.clear();
        test.fill();
        System.out.println(test);
        StdDraw.show();
    }
}
