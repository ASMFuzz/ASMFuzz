import javax.swing.*;
import java.awt.*;

public class MyJVMTest_7854 {

    static Robot robot = null;

    static Object lock = new Object();

    static boolean isRealSyncPerformed = false;

    void run() {
        robot.waitForIdle();
        synchronized (lock) {
            isRealSyncPerformed = true;
            lock.notifyAll();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7854().run();
    }
}
