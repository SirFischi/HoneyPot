public class Point implements drawObject{
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public void draw() {
        StdDraw.point(x, y);
    }

    @Override
    public void fill() {
        this.draw();
    }

    @Override
    public void move(double x, double y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void userInput() {
        while (!StdDraw.isMousePressed()) { }
        this.x = StdDraw.mouseX();
        this.y = StdDraw.mouseY();
    }

    @Override
    public boolean equals(drawObject o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Point)) return false;
        Point o2 = (Point) o;
        return x == o2.getX() && y == o2.getY();
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point: [x = " + x + " | y = " + y + "]";
    }

    public double distance(Point point) {
        double xDist = Math.abs(this.x - point.x);
        double yDist = Math.abs(this.y - point.y);
        return Math.abs(Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2)));
    }

    public double Xdistance(Point point) {
        return Math.abs(this.x - point.x);
    }

    public double Ydistance(Point point) {
        return Math.abs(this.y - point.y);
    }
}
