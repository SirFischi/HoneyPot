public class Square implements drawObject {
    protected double halfWidth;
    protected Point middle;

    public Square(Point middle, double halfWidth) {
        this.halfWidth = halfWidth;
        this.middle = middle;
    }

    public Square() {
        this.middle = new Point(0, 0);
        this.halfWidth = 0;
    }

    @Override
    public void draw() {
        StdDraw.square(middle.getX(), middle.getY(), halfWidth);
    }

    @Override
    public void fill() {
        StdDraw.filledSquare(middle.getX(), middle.getY(), halfWidth);
    }

    @Override
    public void userInput() {
        while (!StdDraw.isMousePressed()) { }
        this.middle.move(StdDraw.mouseX(), StdDraw.mouseY());
        StdDraw.pause(100);
        while (!StdDraw.isMousePressed()) { }
        Point temp = new Point(StdDraw.mouseX(), StdDraw.mouseY());
        this.halfWidth = Math.max(middle.Xdistance(temp), middle.Ydistance(temp));
    }

    @Override
    public void move(double x, double y) {
        this.middle.move(x, y);
    }

    @Override
    public boolean equals(drawObject o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Square)) return false;
        Square o2 = (Square) o;
        return middle == o2.middle && halfWidth == o2.halfWidth;
    }

    @Override
    public String toString() {
        return "Square: [Middle = " + middle + " | HalfWidth = " + halfWidth + "]";
    }
}
