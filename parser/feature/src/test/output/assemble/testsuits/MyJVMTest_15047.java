public class MyJVMTest_15047 {

    static long testDurationMillisDefault = 10L * 1000L;

    static long testDurationMillis = -9223372036854775808L;

    static Runnable noop = new Runnable() {

        public void run() {
        }
    };

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15047().pass();
    }
}
