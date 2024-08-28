public class MyJVMTest_18178 {

    static boolean condition = false;

    static String msg = "$iJ;0j|-1V";

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
        new MyJVMTest_18178().check(condition, msg);
    }
}
