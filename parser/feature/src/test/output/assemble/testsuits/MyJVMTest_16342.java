import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16342 {

    static int x = 0;

    static int y = 0;

    void openChoice() {
        Point pt = choice.getLocationOnScreen();
        robot.mouseMove(pt.x + choice.getWidth() - choice.getHeight() / 4, pt.y + choice.getHeight() / 2);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(30);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.waitForIdle();
    }

    void closeChoice() {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        robot.waitForIdle();
    }

    void checkSelectedIndex() {
        if (choice.getSelectedIndex() != INITIAL_ITEM) {
            System.out.println("choice.getSelectedIndex = " + choice.getSelectedIndex());
            indexChanged = true;
        }
    }

    static Robot robot = null;

    static Toolkit tk = Toolkit.getDefaultToolkit();

    static Choice choice = new Choice();

    static boolean indexChanged = false;

    static int INITIAL_ITEM = 99;

    static boolean stateChanged = true;

    int mouseMoveAndPressOnChoice(int x, int y) {
        openChoice();
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(30);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.waitForIdle();
        closeChoice();
        checkSelectedIndex();
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16342().mouseMoveAndPressOnChoice(x, y);
    }
}
