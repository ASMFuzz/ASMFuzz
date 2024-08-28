public class MyJVMTest_5497 {

    static long testDurationMillisDefault = 10L * 1000L;

    static long testDurationMillis = 0;

    static long quittingTimeNanos = 9223372036854775807L;

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5497().pass();
    }
}
