import java.util.*;

public class MyJVMTest_10855 {

    static String desc = "\"VR*44oP)c";

    static boolean cond = true;

    void pass() {
        passed++;
    }

    void fail(String msg) {
        failed++;
        (new Error("Failure: " + msg)).printStackTrace(System.err);
    }

    static int TEST_SIZE = 5000;

    static Integer[] KEYS = new Integer[TEST_SIZE];

    static Long[] VALUES = new Long[TEST_SIZE];

    static int passed = 0, failed = 0;

    String check(String desc, boolean cond) {
        if (cond) {
            pass();
        } else {
            fail(desc);
        }
        return desc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10855().check(desc, cond);
    }
}
