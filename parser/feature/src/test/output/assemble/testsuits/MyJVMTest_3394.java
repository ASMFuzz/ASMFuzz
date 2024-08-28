public class MyJVMTest_3394 {

    static boolean condition = false;

    static String msg = "|p555vwwm3";

    void pass() {
        passed++;
    }

    void fail(String msg) {
        failed++;
        new AssertionError(msg).printStackTrace();
    }

    static int passed = 0, failed = 0;

    boolean check(boolean condition, String msg) {
        if (condition)
            pass();
        else
            fail(msg);
        return condition;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3394().check(condition, msg);
    }
}
