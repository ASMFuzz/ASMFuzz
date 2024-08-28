import java.io.*;
import java.util.*;
import java.util.zip.*;

public class MyJVMTest_14886 {

    static boolean cond = true;

    boolean pass() {
        passed++;
        return true;
    }

    boolean fail() {
        failed++;
        Thread.dumpStack();
        return false;
    }

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14886().check(cond));
    }
}
