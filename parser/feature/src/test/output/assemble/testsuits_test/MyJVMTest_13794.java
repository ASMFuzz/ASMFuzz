import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_13794 {

    static Component c = new Container();

    static Robot robot = null;

    Component clickTwiceOn(Component c) throws Exception {
        Point p = c.getLocationOnScreen();
        Dimension d = c.getSize();
        if (c instanceof Frame) {
            robot.mouseMove(p.x + (int) (d.getWidth() / 2), p.y + ((Frame) c).getInsets().top / 2);
        } else {
            robot.mouseMove(p.x + (int) (d.getWidth() / 2), p.y + (int) (d.getHeight() / 2));
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep(20);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13794().clickTwiceOn(c);
    }
}
