public class MyJVMTest_7984 {

    static boolean cond = true;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static long testDurationMillisDefault = 10L * 1000L;

    static long testDurationMillis = -956862617328418404L;

    static long quittingTimeNanos = 9223372036854775807L;

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7984().check(cond);
    }
}
