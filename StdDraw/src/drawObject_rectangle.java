public class drawObject_rectangle extends drawObject_square {
    private double halfHeight;

    public drawObject_rectangle(drawObject_point middle, double halfWidth, double halfHeight) {
        this.halfWidth = halfWidth;
        this.halfHeight = halfHeight;
        this.middle = middle;
    }

    public drawObject_rectangle() {
        this.middle = new drawObject_point(0, 0);
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
        drawObject_point temp = new drawObject_point(StdDraw.mouseX(), StdDraw.mouseY());
        this.halfWidth = middle.Xdistance(temp);
        this.halfHeight = middle.Ydistance(temp);
    }

    @Override
    public void move(double x, double y) {
        this.middle.move(x, y);
    }

    @Override
    public boolean equals(drawObject_interface o) {
        if (this == o) return true;
        if (o == null || !(o instanceof drawObject_rectangle)) return false;
        drawObject_rectangle o2 = (drawObject_rectangle) o;
        return middle == o2.middle && halfHeight == o2.halfHeight && halfWidth == o2.halfWidth;
    }

    @Override
    public String toString() {
        return "(rectangle:middle" + middle + ":halfwidth" + halfWidth + ":halfheight" + halfHeight + ")";
    }
}

