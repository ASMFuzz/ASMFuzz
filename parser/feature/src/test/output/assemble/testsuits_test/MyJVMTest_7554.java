import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_7554 {

    void checkEDT() {
        isEDT = isEDT && EventQueue.isDispatchThread();
    }

    static Frame f = null;

    static Dialog d = null;

    static boolean isEDT = true;

    static boolean dialogShown = false;

    static boolean paintCalled = false;

    void run() {
        d.setVisible(true);
        checkEDT();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7554().run();
    }
}
