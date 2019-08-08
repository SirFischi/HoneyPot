import java.awt.*;

public class UserInputTests {
    public static void main(String[] args) {
        int width = 400;
        int height = 400;
        int pause = 300;
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.BLACK);

        System.out.println("rdy");

        Point testPoint = new Point();
        testPoint.userInput();
        testPoint.draw();
        StdDraw.show();

        StdDraw.pause(pause);
        System.out.println("rdy");

        Line testLine = new Line();
        testLine.userInput();
        testLine.draw();
        StdDraw.show();

        StdDraw.pause(pause);
        System.out.println("rdy");

        Circle testCircle = new Circle();
        testCircle.userInput();
        testCircle.draw();
        StdDraw.show();

        StdDraw.pause(pause);
        System.out.println("rdy");

        Square testSquare = new Square();
        testSquare.userInput();
        testSquare.draw();
        StdDraw.show();

        StdDraw.pause(pause);
        System.out.println("rdy");

        Rectangle testRectangle = new Rectangle();
        testRectangle.userInput();
        testRectangle.draw();
        StdDraw.show();

        StdDraw.pause(pause);
        System.out.println("rdy");

        Spline testSpline = new Spline();
        testSpline.userInput();
        testSpline.draw();
        StdDraw.show();

        StdDraw.pause(pause);
        System.out.println("rdy");

        closedSpline testClosedSpline = new closedSpline();
        testClosedSpline.userInput();
        testClosedSpline.draw();
        StdDraw.show();
    }
}
