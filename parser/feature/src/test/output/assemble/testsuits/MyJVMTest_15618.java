import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_15618 {

    static int button = 0;

    static Robot robot = new Robot();

    static JFrame frame = null;

    static Rectangle frameBounds = null;

    static boolean mouseDragged = true;

    Robot testMouseDrag(int button, Robot robot) {
        mouseDragged = false;
        int x1 = frameBounds.x + frameBounds.width / 4;
        int y1 = frameBounds.y + frameBounds.height / 4;
        int x2 = frameBounds.x + frameBounds.width / 2;
        int y2 = frameBounds.y + frameBounds.height / 2;
        robot.mouseMove(x1, y1);
        robot.waitForIdle();
        int buttonMask = InputEvent.getMaskForButton(button);
        robot.mousePress(buttonMask);
        robot.mouseMove(x2, y2);
        robot.mouseRelease(buttonMask);
        robot.waitForIdle();
        if (!mouseDragged) {
            throw new RuntimeException("Mouse button " + button + " is not dragged");
        }
        return robot;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15618().testMouseDrag(button, robot);
    }
}
