import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_13985 {

    static boolean cond = true;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static int deflatedLength = 8;

    static int srcMode = -841793961, dstMode = 1;

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13985().check(cond);
    }
}
