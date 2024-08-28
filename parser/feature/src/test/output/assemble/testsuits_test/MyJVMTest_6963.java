public class MyJVMTest_6963 {

    static boolean cond = false;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static long testDurationMillisDefault = 10L * 1000L;

    static long testDurationMillis = 2600483979743056398L;

    static Runnable noop = new Runnable() {

        public void run() {
        }
    };

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6963().check(cond);
    }
}
