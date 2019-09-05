import java.awt.*;

public class testing_inputTests {
    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.BLACK);

        drawObject_list test = new drawObject_list();

        while (true) {
            StdDraw.show();
            System.out.println(1);
            if (StdDraw.isMousePressed()) {
                drawObject_circle c = drawCircle(new drawObject_point(StdDraw.mouseX(), StdDraw.mouseY()));
                test.add(c);
            }
            test.draw();
        }
    }
    public static drawObject_circle drawCircle(drawObject_point middle) {
        drawObject_circle temp = new drawObject_circle(middle, 0.1);
        while (StdDraw.isMousePressed()) {
            temp.setRadius(middle.distance(new drawObject_point(StdDraw.mouseX(), StdDraw.mouseY())));
        }
        return temp;
    }
}
