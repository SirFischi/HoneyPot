import java.util.ArrayList;

public class drawObjects implements drawObject{
    private ArrayList<drawObject> objectList = new ArrayList<>();

    public drawObjects() { }

    public void add(drawObject x) {
        objectList.add(x);
    }

    public drawObject getFromIndex(int i) {
        if (i < 0 || i >= objectList.size()) return null;
        return objectList.get(i);
    }

    @Override
    public void draw() {
        for (drawObject i:objectList
        ) {
            i.draw();
        }
    }

    @Override
    public void fill() {
        for (drawObject i:objectList
        ) {
            i.fill();
        }
    }

    @Override
    public void userInput() {
        return;
    }

    @Override
    public void move(double x, double y) {
        for (drawObject i:objectList
        ) {
            i.move(x, y);
        }
    }

    @Override
    public boolean equals(drawObject o) {
        if (this == o) return true;
        if (o == null || !(o instanceof drawObject)) return false;
        drawObjects o2 = (drawObjects) o;
        for (int i = 0; i < this.objectList.size(); i++) {
            if (!(this.getFromIndex(i).equals(o2.getFromIndex(i)))) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String t = "";
        for (drawObject i:objectList
             ) {
            t += i.toString() + '\n';
        }
        return t;
    }
}
