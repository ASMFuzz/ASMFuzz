import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_1120 {

    static Robot robot = new Robot();

    static int x0 = 0;

    static int y0 = 0;

    static int x1 = 3;

    static int y1 = 5;

    float glide(Robot robot, int x0, int y0, int x1, int y1) throws AWTException {
        float dmax = (float) Math.max(Math.abs(x1 - x0), Math.abs(y1 - y0));
        float dx = (x1 - x0) / dmax;
        float dy = (y1 - y0) / dmax;
        for (int i = 0; i <= dmax; i += 10) {
            robot.mouseMove((int) (x0 + dx * i), (int) (y0 + dy * i));
        }
        return dmax;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1120().glide(robot, x0, y0, x1, y1);
    }
}
