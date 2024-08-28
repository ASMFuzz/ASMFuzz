import java.awt.Robot;
import java.awt.event.ActionEvent;

public class MyJVMTest_15251 {

    static boolean passed = false;

    static Robot robot = null;

    void checkResult() {
        robot.waitForIdle();
        if (!passed) {
            throw new RuntimeException("If a JDialog is invoker for JPopupMenu, " + "the menu cannot be handled by keyboard.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15251().checkResult();
    }
}
