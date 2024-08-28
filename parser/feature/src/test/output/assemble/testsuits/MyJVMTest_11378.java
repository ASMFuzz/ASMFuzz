import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_11378 {

    static Component test = new Container();

    static BufferedImage capture = null;

    Component doCapture(Component test) {
        try {
            Robot robot = new Robot();
            Point pt1 = test.getLocationOnScreen();
            Rectangle rect = new Rectangle(pt1.x, pt1.y, test.getWidth(), test.getHeight());
            capture = robot.createScreenCapture(rect);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11378().doCapture(test);
    }
}
