import java.nio.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_4595 {

    static boolean cond = false;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static int deflatedLength = 0;

    static int srcMode = 6, dstMode = 662452137;

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4595().check(cond);
    }
}
