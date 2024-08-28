import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_9805 {

    static Robot robot = null;

    static Toolkit tk = Toolkit.getDefaultToolkit();

    static Choice choice = new Choice();

    static boolean indexChanged = false;

    static int INITIAL_ITEM = 99;

    static boolean stateChanged = false;

    void openChoice() {
        Point pt = choice.getLocationOnScreen();
        robot.mouseMove(pt.x + choice.getWidth() - choice.getHeight() / 4, pt.y + choice.getHeight() / 2);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(30);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.waitForIdle();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9805().openChoice();
    }
}
