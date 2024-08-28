import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_10991 {

    static String tParam1Param1 = "6'x8p4w)ah";

    static ThreadGroup tParam1 = new ThreadGroup(tParam1Param1);

    static Runnable tParam2 = () -> {
    };

    static String tParam3 = "TmA.:SV`!:";

    static Thread t = new Thread(tParam1, tParam2, tParam3);

    static Throwable exc = new Throwable();

    static Point pt = null;

    static String failed = "";

    void run() {
        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            public Throwable uncaughtException(Thread t, Throwable exc) {
                failed = exc.toString();
                return exc;
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10991().uncaughtException(t, exc);
    }
}
