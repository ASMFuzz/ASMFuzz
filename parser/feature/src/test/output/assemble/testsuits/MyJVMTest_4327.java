import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import sun.awt.*;

public class MyJVMTest_4327 {

    static String threadParam1Param1 = "YrLij9`WyP";

    static ThreadGroup threadParam1 = new ThreadGroup(threadParam1Param1);

    static Runnable threadParam2 = () -> {
    };

    static String threadParam3 = "{*$LVpSO(9";

    static Thread thread = new Thread(threadParam1, threadParam2, threadParam3);

    static Throwable tParam1 = new Throwable();

    static Throwable t = new Throwable(tParam1);

    static JFrame f = null;

    static boolean exceptionsOccurred = false;

    Throwable uncaughtException(Thread thread, Throwable t) {
        if (t instanceof ThreadDeath) {
            throw (ThreadDeath) t;
        }
        System.err.println("Test FAILED: an exception is caught in the " + "target thread group on thread " + thread.getName());
        t.printStackTrace(System.err);
        exceptionsOccurred = true;
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4327().uncaughtException(thread, t);
    }
}
