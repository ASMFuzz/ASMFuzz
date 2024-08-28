public class MyJVMTest_5631 {

    static long testDurationMillisDefault = 10_000L;

    static long testDurationMillis = 9223372036854775807L;

    static long quittingTimeNanos = 9223372036854775807L;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5631().pass();
    }
}
