import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class MyJVMTest_16574 {

    static Thread t = new Thread();

    static String eParam1 = "r*sz[}CrQ;";

    static String eParam2Param1 = "`8:L5{'4x8";

    static String eParam2Param2Param1 = "h}q'529''t";

    static Throwable eParam2Param2 = new Throwable(eParam2Param2Param1);

    static Throwable eParam2 = new Throwable(eParam2Param1, eParam2Param2);

    static Throwable e = new Throwable(eParam1, eParam2);

    static boolean passed = true;

    Throwable uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        ISCthrownByFileListTest.passed = false;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16574().uncaughtException(t, e);
    }
}
