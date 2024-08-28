public class MyJVMTest_5736 {

    static boolean cond = false;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static long testDurationMillisDefault = 10_000L;

    static long testDurationMillis = 0;

    static long quittingTimeNanos = -2246510342515541176L;

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5736().check(cond);
    }
}
