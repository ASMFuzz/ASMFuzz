public class MyJVMTest_14372 {

    static boolean cond = true;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static long defaultWorkTimeMillis = Long.getLong("millis", 10L);

    static Object elLoco = 0;

    static long quittingTime = 5014253763593596700L;

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
        new MyJVMTest_14372().check(cond);
    }
}
