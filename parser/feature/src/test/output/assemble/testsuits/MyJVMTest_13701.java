import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import sun.awt.*;

public class MyJVMTest_13701 {

    static String threadParam1Param1 = "3RdyPS &[7";

    static ThreadGroup threadParam1 = new ThreadGroup(threadParam1Param1);

    static Runnable threadParam2 = () -> {
    };

    static Thread thread = new Thread(threadParam1, threadParam2);

    static String tParam1 = "^hHLWUDQsx";

    static String tParam2Param1 = ";+@;..2kiv";

    static String tParam2Param2Param1 = ":9~/vuTP1*";

    static Throwable tParam2Param2 = new Throwable(tParam2Param2Param1);

    static boolean tParam2Param3 = false;

    static boolean tParam2Param4 = true;

    static Throwable tParam2 = new Throwable(tParam2Param1, tParam2Param2, tParam2Param3, tParam2Param4);

    static boolean tParam3 = false;

    static boolean tParam4 = true;

    static Throwable t = new Throwable(tParam1, tParam2, tParam3, tParam4);

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
        new MyJVMTest_13701().uncaughtException(thread, t);
    }
}
