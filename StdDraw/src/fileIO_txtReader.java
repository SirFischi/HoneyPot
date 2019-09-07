import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class fileIO_txtReader {
    public static drawObject_list loadFromTxt(String path) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(path));
            return stringToDrawObject(allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static drawObject_list stringToDrawObject(List<String> allLines) {
        drawObject_list list = new drawObject_list();
        for (String line:allLines
             ) {
            if (line.contains(":") && line.charAt(0) != ':') {
                String type = line.substring(1, line.indexOf(':'));
                switch (type) {
                    case "point":
                        list.add(stringToPoint(line));
                        break;
                    case "line":
                        list.add(stringToLine(line));
                        break;
                    case "circle":
                        list.add(stringToCircle(line));
                        break;
                    case "rectangle":
                        list.add(stringToRectangle(line));
                        break;
                    case "square":
                        list.add(stringToSquare(line));
                        break;
                    case "spline":
                        list.add(stringToSpline(line));
                        break;
                    case "closedspline":
                        list.add(stringToClosedSpline(line));
                        break;
                    default:
                        System.out.println("No fitting drawObject found!");
                }
            }
        }
        return list;
    }

    private static drawObject_point stringToPoint(String line) {
        line = line.substring(line.indexOf("point") + 6);
        return new drawObject_point(Double.parseDouble(line.substring(1, line.indexOf(':'))), Double.parseDouble(line.substring(line.indexOf(':') + 2, line.indexOf(')'))));
    }

    private static drawObject_line stringToLine(String line) {
        return new drawObject_line(stringToPoint(line.substring(line.indexOf("start"))), stringToPoint(line.substring(line.indexOf("end"))));
    }

    private static drawObject_circle stringToCircle(String line) {
        return new drawObject_circle(stringToPoint(line), stringToRadius(line));
    }

    private static Double stringToRadius(String line) {
        line = line.substring(line.indexOf("radius") + 6);
        return Double.parseDouble(line.substring(0, line.indexOf(')')));
    }

    private static drawObject_rectangle stringToRectangle(String line) {
        return new drawObject_rectangle(stringToPoint(line), stringToHalfwidthRec(line), stringToHalfheight(line));
    }

    private static Double stringToHalfwidthRec(String line) {
        line = line.substring(line.indexOf("halfwidth") + 9);
        return Double.parseDouble(line.substring(0, line.indexOf(':')));
    }

    private static Double stringToHalfheight(String line) {
        line = line.substring(line.indexOf("halfheight") + 10);
        return Double.parseDouble(line.substring(0, line.indexOf(')')));
    }

    private static drawObject_square stringToSquare(String line) {
        return new drawObject_square(stringToPoint(line), stringToHalfwidthSqu(line));
    }

    private static Double stringToHalfwidthSqu(String line) {
        line = line.substring(line.indexOf("halfwidth") + 9);
        return Double.parseDouble(line.substring(0, line.indexOf(')')));
    }

    private static drawObject_spline stringToSpline(String line) {
        drawObject_spline spline = new drawObject_spline();
        while (line.contains("point")) {
            spline.add(stringToPoint(line));
            line = line.substring(line.indexOf("point") + 6);
        }
        return spline;
    }

    private static drawObject_closedSpline stringToClosedSpline(String line) {
        drawObject_closedSpline spline = new drawObject_closedSpline();
        while (line.contains("point")) {
            spline.add(stringToPoint(line));
            line = line.substring(line.indexOf("point") + 6);
        }
        return spline;
    }



    public static void main(String[] args) {

        int width = 400;
        int height = 400;
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.BLACK);

        drawObject_list test = loadFromTxt("C:\\Users\\itsfs\\Desktop\\drawFile");
        System.out.println(test);

        test.draw();
        StdDraw.show();
    }
}
