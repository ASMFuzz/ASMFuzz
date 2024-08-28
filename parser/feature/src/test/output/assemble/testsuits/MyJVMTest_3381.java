import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_3381 {

    static int CLICKCOUNT = 10;

    static int DOUBLE_CLICK_AUTO_DELAY = 10;

    static int lastClickCount = 0;

    static boolean clicked = false;

    static Robot robot = null;

    void doTest() {
        robot.setAutoDelay(2000);
        robot.waitForIdle();
        robot.keyPress(KeyEvent.VK_B);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(10);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.keyRelease(KeyEvent.VK_B);
        robot.delay(1000);
        robot.setAutoDelay(DOUBLE_CLICK_AUTO_DELAY);
        for (int i = 0; i < CLICKCOUNT / 2; i++) {
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.delay(10);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.keyPress(KeyEvent.VK_B);
            robot.delay(10);
            robot.keyRelease(KeyEvent.VK_B);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.delay(10);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
        robot.waitForIdle();
        robot.delay(200);
        if (!clicked) {
            System.out.println("No MOUSE_CLICKED events received.  Test fails.");
            throw new RuntimeException("No MOUSE_CLICKED events received.  Test fails.");
        }
        if (lastClickCount != CLICKCOUNT) {
            System.out.println("Actual click count: " + lastClickCount + " does not match expected click count: " + CLICKCOUNT + ".  Test fails");
            throw new RuntimeException("Actual click count: " + lastClickCount + " does not match expected click count: " + CLICKCOUNT + ".  Test fails");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3381().doTest();
    }
}
