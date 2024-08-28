import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_12608 {

    void testExitBeforeEnter() throws Exception {
        final SecondaryLoop loop = Toolkit.getDefaultToolkit().getSystemEventQueue().createSecondaryLoop();
        loop.exit();
        Robot robot = new Robot();
        robot.mouseWheel(1);
        robot.waitForIdle();
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                if (loop.enter()) {
                    throw new RuntimeException("Wrong enter() return value");
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12608().run();
    }
}
