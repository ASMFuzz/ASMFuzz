public class MyJVMTest_8912 {

    static boolean condition = false;

    static String msg = "vD,7RKnn&u";

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
        new MyJVMTest_8912().check(condition, msg);
    }
}
