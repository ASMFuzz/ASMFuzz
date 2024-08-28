import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_5446 {

    static Runnable tParam1 = () -> {
    };

    static Thread t = new Thread(tParam1);

    static String excParam1 = "XEv{f8)v,o";

    static Throwable exc = new Throwable(excParam1);

    static Point pt = null;

    static String failed = "";

    Throwable uncaughtException(Thread t, Throwable exc) {
        failed = exc.toString();
        return exc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5446().uncaughtException(t, exc);
    }
}
