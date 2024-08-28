import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class MyJVMTest_7057 {

    static String tParam1 = "S=pTLNZ-i@";

    static Thread t = new Thread(tParam1);

    static String eParam1 = "~U%Xle.!09";

    static String eParam2Param1 = "+liFQqW0yw";

    static Throwable eParam2 = new Throwable(eParam2Param1);

    static boolean eParam3 = false;

    static boolean eParam4 = true;

    static Throwable e = new Throwable(eParam1, eParam2, eParam3, eParam4);

    static boolean passed = true;

    Throwable uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        ISCthrownByFileListTest.passed = false;
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7057().uncaughtException(t, e);
    }
}
