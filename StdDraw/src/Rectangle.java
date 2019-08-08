public class Rectangle extends Square {
    private double halfHeight;

    public Rectangle(Point middle, double halfWidth, double halfHeight) {
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
        this.middle = middle;
    }

    public Rectangle() {
        this.middle = new Point(0, 0);
        this.halfWidth = 0;
        this.halfHeight = 0;
    }

    @Override
    public void draw() {
        StdDraw.rectangle(middle.getX(), middle.getY(), halfWidth, halfHeight);
    }

    @Override
    public void fill() {
        StdDraw.filledRectangle(middle.getX(), middle.getY(), halfWidth, halfHeight);
    }

    @Override
    public void userInput() {
        while (!StdDraw.isMousePressed()) { }
        this.middle.move(StdDraw.mouseX(), StdDraw.mouseY());
        StdDraw.pause(100);
        while (!StdDraw.isMousePressed()) { }
        Point temp = new Point(StdDraw.mouseX(), StdDraw.mouseY());
        this.halfWidth = middle.Xdistance(temp);
        this.halfHeight = middle.Ydistance(temp);
    }

    @Override
    public void move(double x, double y) {
        this.middle.move(x, y);
    }

    @Override
    public boolean equals(drawObject o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Rectangle)) return false;
        Rectangle o2 = (Rectangle) o;
        return middle == o2.middle && halfHeight == o2.halfHeight && halfWidth == o2.halfWidth;
    }

    @Override
    public String toString() {
        return "Rectangle: [Middle = " + middle + " | HalfWidth = " + halfWidth + " | HalfHeight = " + halfHeight + "]";
    }
}

