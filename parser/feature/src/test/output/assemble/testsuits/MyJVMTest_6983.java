import java.util.*;

public class MyJVMTest_6983 {

    static boolean cond = false;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        (new Error("Failure")).printStackTrace(System.err);
    }

    static int TEST_SIZE = 5000;

    static Integer[] KEYS = new Integer[TEST_SIZE];

    static Long[] VALUES = new Long[TEST_SIZE];

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond) {
            pass();
        } else {
            fail();
        }
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6983().check(cond);
    }
}
