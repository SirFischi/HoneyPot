public class Line implements drawObject{
    private Point start, end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line() {
        this.start = new Point(0, 0);
        this.end = new Point(0, 0);
    }

    public Line(double startX, double endX, double startY, double endY) {
        this.start = new Point(startX, endX);
        this.end = new Point(startY, endY);
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
    public boolean equals(drawObject o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Line)) return false;
        Line o2 = (Line) o;
        return start == o2.start && end == o2.end;
    }

    @Override
    public String toString() {
        return "Line: [Start = " + start + " | End = " + end + "]";

    }
}
