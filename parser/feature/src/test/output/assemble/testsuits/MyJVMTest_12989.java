import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12989 {

    static Robot robot = null;

    void pressTab() {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12989().pressTab();
    }
}
