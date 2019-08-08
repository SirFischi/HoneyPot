public class Circle implements drawObject{
    private Point middle;
    private double radius;

    public Circle(Point middle, double radius) {
        this.middle = middle;
        this.radius = radius;
    }

    public Circle() {
        this.middle = new Point(0, 0);
        this.radius = 0;
    }

    @Override
    public void draw() {
        StdDraw.circle(middle.getX(), middle.getY(), radius);
    }

    @Override
    public void fill() {
        StdDraw.filledCircle(middle.getX(), middle.getY(), radius);
    }

    @Override
    public void userInput() {
        while (!StdDraw.isMousePressed()) { }
        this.middle.move(StdDraw.mouseX(), StdDraw.mouseY());
        StdDraw.pause(100);
        while (!StdDraw.isMousePressed()) { }
        this.radius = middle.distance(new Point(StdDraw.mouseX(), StdDraw.mouseY()));

    }

    @Override
    public void move(double x, double y) {
        this. middle.move(x, y);
    }

    @Override
    public boolean equals(drawObject o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Circle)) return false;
        Circle o2 = (Circle) o;
        return middle == o2.middle && radius == o2.radius;
    }

    @Override
    public String toString() {
        return "Circle: [Middle = " + middle + " | Radius = " + radius + "]";
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
