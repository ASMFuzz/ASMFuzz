import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_15322 {

    static String eParam1 = "Q`x;qj~|kI";

    static String eParam2Param1 = "Rrl2OM:>R<";

    static String eParam2Param2Param1 = "&g+[76b'jb";

    static Throwable eParam2Param2 = new Throwable(eParam2Param2Param1);

    static boolean eParam2Param3 = true;

    static boolean eParam2Param4 = true;

    static Throwable eParam2 = new Throwable(eParam2Param1, eParam2Param2, eParam2Param3, eParam2Param4);

    static Exception e = new Exception(eParam1, eParam2);

    static Enumeration ifs = null;

    static Class filter = null;

    static Runnable runnee = null;

    static long delay = 0;

    static String osname = "3L!.1{..[9";

    Exception unexpected(Exception e) {
        System.out.println("Unexcepted Exception: " + e);
        e.printStackTrace();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15322().unexpected(e);
    }
}
