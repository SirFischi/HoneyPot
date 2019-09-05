import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class drawObject_spline implements drawObject_interface {
    protected ArrayList<drawObject_point> points = new ArrayList<>();

    public drawObject_spline() { }

    public void add(drawObject_point p) {
        this.points.add(p);
    }

    public drawObject_interface getFromIndex(int i) {
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
            this.points.add(new drawObject_point(StdDraw.mouseX(), StdDraw.mouseY()));
            this.drawLast();
            StdDraw.show();
            StdDraw.pause(100);
        }
    }

    @Override
    public void move(double x, double y) {
        for (drawObject_point p:points
             ) {
            p.move(x, y);
        }
    }

    @Override
    public boolean equals(drawObject_interface o) {
        if (this == o) return true;
        if (o == null || !(o instanceof drawObject_spline)) return false;
        drawObject_spline o2 = (drawObject_spline) o;
        for (int i = 0; i < this.points.size(); i++) {
            if (!(this.getFromIndex(i).equals(o2.getFromIndex(i)))) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String t = "(";
        for (drawObject_interface i:points
        ) {
            t += i.toString();
        }
        return t + ")";
    }

    public void drawLast() {
        if (this.points.size() < 2) return;
        drawObject_line temp = new drawObject_line((drawObject_point)(this.getFromIndex(this.points.size() - 1)), (drawObject_point)(this.getFromIndex(this.points.size() - 2)));
        temp.draw();
    }
}
