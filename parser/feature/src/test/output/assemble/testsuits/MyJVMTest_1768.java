import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_1768 {

    static String tParam1 = "J8rY>cD>:*";

    static Thread t = new Thread(tParam1);

    static String excParam1 = "Ve~/kle$j}";

    static String excParam2Param1 = "eN@ d$5D[w";

    static String excParam2Param2Param1 = "q^^,7[\\+D8";

    static Throwable excParam2Param2Param2Param1Param1 = new Throwable();

    static Throwable excParam2Param2Param2Param1 = new Throwable(excParam2Param2Param2Param1Param1);

    static Throwable excParam2Param2Param2 = new Throwable(excParam2Param2Param2Param1);

    static Throwable excParam2Param2 = new Throwable(excParam2Param2Param1, excParam2Param2Param2);

    static boolean excParam2Param3 = true;

    static boolean excParam2Param4 = false;

    static Throwable excParam2 = new Throwable(excParam2Param1, excParam2Param2, excParam2Param3, excParam2Param4);

    static Throwable exc = new Throwable(excParam1, excParam2);

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
        new MyJVMTest_1768().uncaughtException(t, exc);
    }
}
