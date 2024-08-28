import java.io.*;
import java.util.*;
import java.nio.charset.*;
import java.nio.*;

public class MyJVMTest_16795 {

    static boolean cond = false;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static byte[] lowBytes = new byte[0xa0];

    static char[] lowChars = new char[0xa0];

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16795().check(cond);
    }
}
