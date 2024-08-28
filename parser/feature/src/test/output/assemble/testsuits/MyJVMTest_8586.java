public class MyJVMTest_8586 {

    static boolean condition = true;

    static String msg = ".da9 P=jH2";

    void fail(String msg) {
        failed++;
        new AssertionError(msg).printStackTrace();
    }

    static int passed = 0, failed = 0;

    boolean check(boolean condition, String msg) {
        if (condition)
            passed++;
        else
            fail(msg);
        return condition;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8586().check(condition, msg);
    }
}
