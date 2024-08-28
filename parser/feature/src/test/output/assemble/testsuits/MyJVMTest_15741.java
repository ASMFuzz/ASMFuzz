public class MyJVMTest_15741 {

    static boolean cond = false;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static Object x = -665842697;

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15741().check(cond);
    }
}
