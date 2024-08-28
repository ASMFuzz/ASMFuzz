public class MyJVMTest_4966 {

    static boolean cond = false;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static long defaultWorkTimeMillis = Long.getLong("millis", 10L);

    static Object elLoco = 1876366785;

    static long quittingTime = -9223372036854775808L;

    static int i = 0;

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4966().check(cond);
    }
}
