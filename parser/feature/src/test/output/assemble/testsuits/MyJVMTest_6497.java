import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyJVMTest_6497 {

    static Vector<Window> wl1 = null;

    static Vector<Window> wl2 = null;

    static String methodName = "@FYW0+j't`";

    void fail(String whyFailed) {
        if (mainThread == Thread.currentThread()) {
            throw new RuntimeException(whyFailed);
        }
        theTestPassed = false;
        testGeneratedInterrupt = true;
        failureMessage = whyFailed;
        mainThread.interrupt();
    }

    static Vector<Window> windows = new Vector<Window>();

    static boolean theTestPassed = false;

    static boolean testGeneratedInterrupt = false;

    static String failureMessage = "";

    static Thread mainThread = null;

    Vector<Window> checkWindowsList(Vector<Window> wl1, Vector<Window> wl2, String methodName) {
        if ((wl1.size() != wl2.size()) || !wl1.containsAll(wl2) || !wl2.containsAll(wl1)) {
            fail("Test FAILED: method " + methodName + " returns incorrect list of windows");
        }
        return wl1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6497().checkWindowsList(wl1, wl2, methodName);
    }
}
