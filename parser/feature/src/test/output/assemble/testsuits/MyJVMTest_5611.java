public class MyJVMTest_5611 {

    static long testDurationMillisDefault = 10L * 1000L;

    static long testDurationMillis = 9223372036854775807L;

    static Runnable noop = new Runnable() {

        public void run() {
        }
    };

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5611().pass();
    }
}
