public class drawObject_square implements drawObject_interface {
    protected double halfWidth;
    protected drawObject_point middle;

    public drawObject_square(drawObject_point middle, double halfWidth) {
        this.halfWidth = halfWidth;
        this.middle = middle;
    }

    public drawObject_square() {
        this.middle = new drawObject_point(0, 0);
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
        drawObject_point temp = new drawObject_point(StdDraw.mouseX(), StdDraw.mouseY());
        this.halfWidth = Math.max(middle.Xdistance(temp), middle.Ydistance(temp));
    }

    @Override
    public void move(double x, double y) {
        this.middle.move(x, y);
    }

    @Override
    public boolean equals(drawObject_interface o) {
        if (this == o) return true;
        if (o == null || !(o instanceof drawObject_square)) return false;
        drawObject_square o2 = (drawObject_square) o;
        return middle == o2.middle && halfWidth == o2.halfWidth;
    }

    @Override
    public String toString() {
        return "(square:middle" + middle + ":halfwidth" + halfWidth + ")";
    }
}
