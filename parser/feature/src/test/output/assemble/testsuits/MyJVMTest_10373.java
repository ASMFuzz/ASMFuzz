import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_10373 {

    static Frame f = null;

    static Dialog d = null;

    static boolean isEDT = true;

    static boolean dialogShown = false;

    static boolean paintCalled = false;

    void checkEDT() {
        isEDT = isEDT && EventQueue.isDispatchThread();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10373().checkEDT();
    }
}
