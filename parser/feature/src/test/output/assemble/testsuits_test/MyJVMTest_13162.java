import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import javax.swing.*;

public class MyJVMTest_13162 {

    static Window topw = null;

    static Robot robot = null;

    void postAction_3() {
        Point p = topw.getLocationOnScreen();
        int x = p.x + 40, y = p.y + 5;
        try {
            Thread.sleep(500);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        } catch (IllegalComponentStateException e) {
            e.printStackTrace();
        }
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseMove(200, 50);
        robot.mouseMove(x, y);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13162().postAction_3();
    }
}
