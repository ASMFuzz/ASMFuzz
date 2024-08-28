import java.net.*;
import java.io.*;
import java.util.*;

public class MyJVMTest_9496 {

    static boolean assertion = false;

    static Enumeration ifs = null;

    static Class filter = null;

    static Runnable runnee = null;

    static long delay = 9223372036854775807L;

    static String osname = "sL}&@z?tl<";

    boolean t_assert(boolean assertion) {
        if (assertion) {
            return;
        }
        Throwable t = new Throwable();
        StackTraceElement[] strace = t.getStackTrace();
        String msg = "Assertion failed at: " + strace[1].toString();
        throw new RuntimeException(msg);
        return assertion;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9496().t_assert(assertion);
    }
}
