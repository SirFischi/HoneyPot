public class drawObject_line implements drawObject_interface {
    private drawObject_point start, end;

    public drawObject_line(drawObject_point start, drawObject_point end) {
        this.start = start;
        this.end = end;
    }

    public drawObject_line() {
        this.start = new drawObject_point(0, 0);
        this.end = new drawObject_point(0, 0);
    }

    public drawObject_line(double startX, double endX, double startY, double endY) {
        this.start = new drawObject_point(startX, endX);
        this.end = new drawObject_point(startY, endY);
    }

    @Override
    public void draw() {
        StdDraw.line(start.getX(), start.getY(), end.getX(), end.getY());
    }

    @Override
    public void fill() {
        this.draw();
    }

    @Override
    public void userInput() {
        while (!StdDraw.isMousePressed()) { }
        start.move(StdDraw.mouseX(), StdDraw.mouseY());
        StdDraw.pause(100);
        while (!StdDraw.isMousePressed()) { }
        end.move(StdDraw.mouseX(), StdDraw.mouseY());
    }

    @Override
    public void move(double x, double y) {
        this.start.move(x, y);
        this.end.move(x, y);
    }

    @Override
    public boolean equals(drawObject_interface o) {
        if (this == o) return true;
        if (o == null || !(o instanceof drawObject_line)) return false;
        drawObject_line o2 = (drawObject_line) o;
        return start == o2.start && end == o2.end;
    }

    @Override
    public String toString() {
        return "(line:start" + start + ":end" + end + ")";

    }
}
