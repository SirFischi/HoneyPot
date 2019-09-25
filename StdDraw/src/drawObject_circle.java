public class drawObject_circle implements drawObject_interface { //hhhhh
    private drawObject_point middle;
    private double radius;

    public drawObject_circle(drawObject_point middle, double radius) {
        this.middle = middle;
        this.radius = radius;
    }

    public drawObject_circle() {
        this.middle = new drawObject_point(0, 0);
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
        this.radius = middle.distance(new drawObject_point(StdDraw.mouseX(), StdDraw.mouseY()));

    }

    @Override
    public void move(double x, double y) {
        this. middle.move(x, y);
    }

    @Override
    public boolean equals(drawObject_interface o) {
        if (this == o) return true;
        if (o == null || !(o instanceof drawObject_circle)) return false;
        drawObject_circle o2 = (drawObject_circle) o;
        return middle == o2.middle && radius == o2.radius;
    }

    @Override
    public String toString() {
        return "(circle:middle" + middle + ":radius" + radius + ")";
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
