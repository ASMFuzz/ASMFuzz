import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_9843 {

    static Robot robot = null;

    static Toolkit tk = Toolkit.getDefaultToolkit();

    static Choice choice = new Choice();

    static boolean indexChanged = false;

    static int INITIAL_ITEM = 99;

    static boolean stateChanged = true;

    void closeChoice() {
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        robot.waitForIdle();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9843().closeChoice();
    }
}
