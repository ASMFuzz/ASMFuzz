import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_11756 {

    static Choice choice1 = new Choice();

    static Robot robot = null;

    static Point pt = null;

    void testSpacePress() {
        pt = choice1.getLocationOnScreen();
        robot.mouseMove(pt.x + choice1.getWidth() / 2, pt.y + choice1.getHeight() / 2);
        robot.waitForIdle();
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.waitForIdle();
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.waitForIdle();
        robot.mouseMove(pt.x + choice1.getWidth() / 2, pt.y + 2 * choice1.getHeight());
        robot.waitForIdle();
        robot.mouseMove(pt.x + choice1.getWidth() / 2, pt.y - choice1.getHeight());
        robot.waitForIdle();
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.waitForIdle();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11756().testSpacePress();
    }
}
