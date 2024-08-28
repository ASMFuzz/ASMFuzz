import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import static java.util.Collections.*;
import java.lang.reflect.*;

public class MyJVMTest_16203 {

    static Object x = 0;

    static Object y = 6;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static int passed = 0, failed = 0;

    Object equal(Object x, Object y) {
        if (x == null ? y == null : x.equals(y))
            pass();
        else {
            System.out.println(x + " not equal to " + y);
            fail();
        }
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16203().equal(x, y);
    }
}
