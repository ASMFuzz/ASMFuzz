import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_1824 {

    static int ATTEMPTS = 100;

    static int EVENTS = 5;

    static int disorderCounter = 0;

    static Boolean enterReturn = false;

    static Boolean exitReturn = false;

    static int dispatchedEvents = 7;

    void testRandomly() throws AWTException {
        disorderCounter = 0;
        final Robot robot = new Robot();
        robot.setAutoDelay(1);
        for (int i = 0; i < ATTEMPTS; i++) {
            enterReturn = null;
            exitReturn = null;
            dispatchedEvents = 0;
            synchronized (bug6980209.class) {
                try {
                    for (int j = 0; j < EVENTS; j++) {
                        robot.keyPress(KeyEvent.VK_1);
                        robot.keyRelease(KeyEvent.VK_1);
                    }
                    robot.keyPress(KeyEvent.VK_SPACE);
                    robot.keyRelease(KeyEvent.VK_SPACE);
                    for (int j = 0; j < EVENTS; j++) {
                        robot.keyPress(KeyEvent.VK_1);
                        robot.keyRelease(KeyEvent.VK_1);
                    }
                    long time = System.nanoTime();
                    bug6980209.class.wait(1000);
                    if (enterReturn == null) {
                        System.out.println("wait time=" + ((System.nanoTime() - time) / 1E9) + " seconds");
                        throw new RuntimeException("It seems the secondary loop will never end");
                    }
                    if (!enterReturn)
                        disorderCounter++;
                    robot.waitForIdle();
                    if (dispatchedEvents < 2 * EVENTS) {
                        throw new RuntimeException("KeyEvent.VK_1 has been lost!");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException("Interrupted!");
                }
            }
        }
        if (disorderCounter == 0) {
            System.out.println("Zero disordered enter/exit caught. It is recommended to run scenario again");
        } else {
            System.out.println("Disordered calls is " + disorderCounter + " from " + ATTEMPTS);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1824().testRandomly();
    }
}
