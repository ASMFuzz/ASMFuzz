import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14875 {

    static String tParam1Param1Param1 = "#tK+&[?]nk";

    static ThreadGroup tParam1Param1 = new ThreadGroup(tParam1Param1Param1);

    static String tParam1Param2 = "HW;@E%~RDY";

    static ThreadGroup tParam1 = new ThreadGroup(tParam1Param1, tParam1Param2);

    static Runnable tParam2 = () -> {
    };

    static Thread t = new Thread(tParam1, tParam2);

    static Throwable exc = new Throwable();

    static Point pt = null;

    static String failed = "";

    Throwable uncaughtException(Thread t, Throwable exc) {
        failed = exc.toString();
        return exc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14875().uncaughtException(t, exc);
    }
}
