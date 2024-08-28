import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_3511 {

    void checkEDT() {
        isEDT = isEDT && EventQueue.isDispatchThread();
    }

    static Frame f = null;

    static Dialog d = null;

    static boolean isEDT = true;

    static Object test3Lock = new Object();

    static boolean test3Sync = false;

    static boolean dialogShown = false;

    static boolean paintCalled = false;

    void run() {
        d.dispose();
        checkEDT();
        synchronized (test3Lock) {
            test3Sync = true;
            test3Lock.notify();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3511().run();
    }
}
