import java.awt.event.KeyEvent;

public class closedSpline extends Spline {
    @Override
    public void draw() {
        for (int i = 1; i < points.size(); i++) {
            StdDraw.line(points.get(i - 1).getX(), points.get(i - 1).getY(), points.get(i).getX(), points.get(i).getY());
        }
        StdDraw.line(points.get(points.size() - 1).getX(), points.get(points.size() - 1).getY(), points.get(0).getX(), points.get(0).getY());
    }

    @Override
    public void fill() { }

    @Override
    public void userInput() {
        while (true) {
            while (!StdDraw.isMousePressed()) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) return;
            }
            if (points.size() > 2 && points.get(0).distance(new Point(StdDraw.mouseX(), StdDraw.mouseY())) < 10) return;
            this.points.add(new Point(StdDraw.mouseX(), StdDraw.mouseY()));
            this.drawLast();
            StdDraw.show();
            StdDraw.pause(100);
        }
    }

    private boolean[][] convertToArray() {
        boolean[][] boolArray = new boolean[(int)this.width()][(int)this.height()];

        return boolArray;
    }

    private double width() {
        double xLow = points.get(0).getX();
        for (Point p:points
             ) {
            if (p.getX() < xLow) xLow = p.getX();
        }
        double xHigh = points.get(0).getX();
        for (Point p:points
        ) {
            if (p.getX() > xHigh) xHigh = p.getX();
        }
        return xHigh - xLow;
    }

    private double height() {
        double yLow = points.get(0).getY();
        for (Point p:points
        ) {
            if (p.getY() < yLow) yLow = p.getY();
        }
        double yHigh = points.get(0).getY();
        for (Point p:points
        ) {
            if (p.getY() > yHigh) yHigh = p.getY();
        }
        return yHigh - yLow;
    }
}
