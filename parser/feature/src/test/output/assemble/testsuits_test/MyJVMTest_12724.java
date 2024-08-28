public class MyJVMTest_12724 {

    static boolean condition = false;

    static String msg = "SB<l=A2V;f";

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
        new MyJVMTest_12724().check(condition, msg);
    }
}
