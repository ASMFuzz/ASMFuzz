public class MyJVMTest_15178 {

    static boolean cond = true;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static long testDurationMillisDefault = 10_000L;

    static long testDurationMillis = 193091768901022749L;

    static long quittingTimeNanos = -9223372036854775808L;

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15178().check(cond);
    }
}
