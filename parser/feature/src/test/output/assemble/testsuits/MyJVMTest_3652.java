import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_3652 {

    static Robot robot = null;

    void pressTab() {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3652().pressTab();
    }
}
