import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12126 {

    static Robot robot = null;

    void printABCD() {
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_B);
        robot.keyRelease(KeyEvent.VK_B);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12126().printABCD();
    }
}
