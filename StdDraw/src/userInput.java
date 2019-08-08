public class userInput {

    public static Circle drawCircle(Point middle) {
        Circle temp = new Circle(middle, 0.1);
        while (StdDraw.isMousePressed()) {
            temp.setRadius(middle.distance(new Point(StdDraw.mouseX(), StdDraw.mouseY())));
        }
        return temp;
    }
}
