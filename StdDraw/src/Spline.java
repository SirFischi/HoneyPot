import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Spline implements drawObject{
    protected ArrayList<Point> points = new ArrayList<>();

    public Spline() { }

    public void add(Point p) {
        this.points.add(p);
    }

    public drawObject getFromIndex(int i) {
        if (i < 0 || i >= points.size()) return null;
        return points.get(i);
    }

    @Override
    public void draw() {
        for (int i = 1; i < points.size(); i++) {
            StdDraw.line(points.get(i - 1).getX(), points.get(i - 1).getY(), points.get(i).getX(), points.get(i).getY());
        }
    }

    @Override
    public void fill() {
        this.draw();
    }

    @Override
    public void userInput() {
        while (true) {
            while (!StdDraw.isMousePressed()) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE)) return;
            }
            this.points.add(new Point(StdDraw.mouseX(), StdDraw.mouseY()));
            this.drawLast();
            StdDraw.show();
            StdDraw.pause(100);
        }
    }

    @Override
    public void move(double x, double y) {
        for (Point p:points
             ) {
            p.move(x, y);
        }
    }

    @Override
    public boolean equals(drawObject o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Spline)) return false;
        Spline o2 = (Spline) o;
        for (int i = 0; i < this.points.size(); i++) {
            if (!(this.getFromIndex(i).equals(o2.getFromIndex(i)))) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String t = "";
        for (drawObject i:points
        ) {
            t += i.toString() + '\n';
        }
        return t;
    }

    public void drawLast() {
        if (this.points.size() < 2) return;
        Line temp = new Line((Point)(this.getFromIndex(this.points.size() - 1)), (Point)(this.getFromIndex(this.points.size() - 2)));
        temp.draw();
    }
}
