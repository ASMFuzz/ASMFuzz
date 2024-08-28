import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_11748 {

    static Choice theChoice = null;

    static Robot robot = null;

    static Object lock = new Object();

    void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        Point loc = theChoice.getLocationOnScreen();
        Dimension size = theChoice.getSize();
        robot.mouseMove(loc.x + size.width - 10, loc.y + size.height / 2);
        robot.setAutoDelay(250);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.setAutoDelay(1000);
        robot.mouseMove(loc.x + size.width / 2, loc.y + size.height + size.height / 2);
        robot.setAutoDelay(250);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.waitForIdle();
        synchronized (lock) {
            lock.notify();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11748().run();
    }
}
