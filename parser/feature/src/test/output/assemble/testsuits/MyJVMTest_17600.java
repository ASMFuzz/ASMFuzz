import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import static java.util.Collections.*;
import java.lang.reflect.*;

public class MyJVMTest_17600 {

    static Object x = 2;

    static Object y = -23808476;

    static String msg = "9sTE$i 9%m";

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static int passed = 0, failed = 0;

    Object equal(Object x, Object y, String msg) {
        if (x == null ? y == null : x.equals(y))
            pass();
        else {
            System.out.println(x + " not equal to " + y + " : " + msg);
            fail();
        }
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17600().equal(x, y, msg);
    }
}
