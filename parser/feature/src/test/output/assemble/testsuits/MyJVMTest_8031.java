import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import static java.util.Collections.*;
import java.lang.reflect.*;

public class MyJVMTest_8031 {

    static Object x = 6;

    static Object y = 0;

    static String msg = "=OQzN7C!Wn";

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
        new MyJVMTest_8031().equal(x, y, msg);
    }
}
