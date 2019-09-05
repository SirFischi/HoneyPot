public class drawObject_point implements drawObject_interface {
    private double x, y;

    public drawObject_point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public drawObject_point() {
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
    public boolean equals(drawObject_interface o) {
        if (this == o) return true;
        if (o == null || !(o instanceof drawObject_point)) return false;
        drawObject_point o2 = (drawObject_point) o;
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
        return "(point:x" + x + ":y" + y + ")";
    }


    public double distance(drawObject_point point) {
        double xDist = Math.abs(this.x - point.x);
        double yDist = Math.abs(this.y - point.y);
        return Math.abs(Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2)));
    }

    public double Xdistance(drawObject_point point) {
        return Math.abs(this.x - point.x);
    }

    public double Ydistance(drawObject_point point) {
        return Math.abs(this.y - point.y);
    }
}
