import java.io.*;
import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_8611 {

    static boolean cond = true;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static String name = "XeC6\"X7iQ$";

    static byte[] data = {2,-5,-103,87,-21,40,-27,60,56,94};

    static int level = 0;

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
        System.out.println(new MyJVMTest_8611().check(cond));
    }
}
