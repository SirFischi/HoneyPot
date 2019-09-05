import java.awt.*;

public class testing_userInputTests {
    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        int pause = 300;
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.BLACK);

        System.out.println("rdy");

        drawObject_point testPoint = new drawObject_point();
        testPoint.userInput();
        testPoint.draw();
        StdDraw.show();

        StdDraw.pause(pause);
        System.out.println("rdy");

        drawObject_line testLine = new drawObject_line();
        testLine.userInput();
        testLine.draw();
        StdDraw.show();

        StdDraw.pause(pause);
        System.out.println("rdy");

        drawObject_circle testCircle = new drawObject_circle();
        testCircle.userInput();
        testCircle.draw();
        StdDraw.show();

        StdDraw.pause(pause);
        System.out.println("rdy");

        drawObject_square testSquare = new drawObject_square();
        testSquare.userInput();
        testSquare.draw();
        StdDraw.show();

        StdDraw.pause(pause);
        System.out.println("rdy");

        drawObject_rectangle testRectangle = new drawObject_rectangle();
        testRectangle.userInput();
        testRectangle.draw();
        StdDraw.show();

        StdDraw.pause(pause);
        System.out.println("rdy");

        drawObject_spline testSpline = new drawObject_spline();
        testSpline.userInput();
        testSpline.draw();
        StdDraw.show();

        StdDraw.pause(pause);
        System.out.println("rdy");

        drawObject_closedSpline testClosedSpline = new drawObject_closedSpline();
        testClosedSpline.userInput();
        testClosedSpline.draw();
        StdDraw.show();
    }
}
