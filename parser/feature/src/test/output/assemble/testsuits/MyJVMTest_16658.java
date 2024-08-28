import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16658 {

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

    void pressTab() {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    void clickWindowsTitle(JFrame frame) {
        Point point = frame.getLocationOnScreen();
        robot.mouseMove(point.x + (frame.getWidth() / 2), point.y + frame.getInsets().top / 2);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    static Robot robot = null;

    static JFrame firstFrame = null;

    static JFrame secondFrame = null;

    void runScript() {
        robot.delay(1000);
        printABCD();
        pressTab();
        clickWindowsTitle(secondFrame);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_ALT);
        clickWindowsTitle(firstFrame);
        robot.waitForIdle();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16658().runScript();
    }
}
