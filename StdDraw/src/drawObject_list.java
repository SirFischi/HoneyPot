import java.util.ArrayList;

public class drawObject_list implements drawObject_interface {
    private ArrayList<drawObject_interface> objectList = new ArrayList<>();

    public drawObject_list() { }

    public void add(drawObject_interface x) {
        objectList.add(x);
    }

    public drawObject_interface getFromIndex(int i) {
        if (i < 0 || i >= objectList.size()) return null;
        return objectList.get(i);
    }

    @Override
    public void draw() {
        for (drawObject_interface i:objectList
        ) {
            i.draw();
        }
    }

    @Override
    public void fill() {
        for (drawObject_interface i:objectList
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
        for (drawObject_interface i:objectList
        ) {
            i.move(x, y);
        }
    }

    @Override
    public boolean equals(drawObject_interface o) {
        if (this == o) return true;
        if (o == null || !(o instanceof drawObject_interface)) return false;
        drawObject_list o2 = (drawObject_list) o;
        for (int i = 0; i < this.objectList.size(); i++) {
            if (!(this.getFromIndex(i).equals(o2.getFromIndex(i)))) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String t = "";
        for (drawObject_interface i:objectList
             ) {
            t += i.toString() + "\r\n";
        }
        return t;
    }
}
