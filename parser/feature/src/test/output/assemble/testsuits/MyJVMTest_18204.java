import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_18204 {

    static boolean cond = false;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static String name = "V`z(xh{~GY";

    static byte[] data = {119,98,100,-16,121,45,-73,-23,-97,-6};

    static int level = 376720475;

    static int STRIDE = 1024;

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18204().check(cond));
    }
}
