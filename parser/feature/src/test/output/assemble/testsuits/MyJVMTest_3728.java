public class MyJVMTest_3728 {

    static boolean cond = false;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static String k = "foo";

    static Long v = 1L;

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3728().check(cond);
    }
}
