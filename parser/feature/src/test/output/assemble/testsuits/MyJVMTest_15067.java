public class MyJVMTest_15067 {

    static long testDurationMillisDefault = 10_000L;

    static long testDurationMillis = 0;

    static long quittingTimeNanos = -9223372036854775808L;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15067().pass();
    }
}
