import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class fileIO_txt {

public static void writeToFile(drawObject_list list) {
    try{
        FileWriter fw = new FileWriter("C:\\Users\\itsfs\\Desktop\\drawFile");
        fw.write(list.toString());
        fw.close();
    }catch(Exception e) {
        System.out.println(e);
    }
}

    public static void main(String[] args) {

        int width = 400;
        int height = 400;
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.enableDoubleBuffering();
        StdDraw.setPenColor(Color.BLACK);

        drawObject_list testi = new drawObject_list();
        testi.add(new drawObject_point(200, 200));
        testi.add(new drawObject_line(0, 0, 100, 100));
        testi.add(new drawObject_circle(new drawObject_point(300, 300), 50));
        testi.add(new drawObject_rectangle(new drawObject_point(200, 300), 30, 60));
        testi.add(new drawObject_square(new drawObject_point(300, 50), 30));
        drawObject_spline spline = new drawObject_spline();
        spline.add(new drawObject_point(1, 30));
        spline.add(new drawObject_point(100, 4));
        spline.add(new drawObject_point(5, 4));
        spline.add(new drawObject_point(10, 10));
        spline.add(new drawObject_point(300, 200));
        testi.add(spline);
        drawObject_closedSpline splinec= new drawObject_closedSpline();
        splinec.add(new drawObject_point(300, 40));
        splinec.add(new drawObject_point(200, 170));
        splinec.add(new drawObject_point(100, 340));
        testi.add(splinec);
        testi.draw();
        StdDraw.show();
        writeToFile(testi);
    }
}

