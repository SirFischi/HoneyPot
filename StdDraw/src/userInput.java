public class userInput {

    public static drawObject_circle drawCircle(drawObject_point middle) {
        drawObject_circle temp = new drawObject_circle(middle, 0.1);
        while (StdDraw.isMousePressed()) {
            temp.setRadius(middle.distance(new drawObject_point(StdDraw.mouseX(), StdDraw.mouseY())));
        }
        return temp;
    }
}
