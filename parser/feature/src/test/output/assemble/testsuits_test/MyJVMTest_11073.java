public class MyJVMTest_11073 {

    static boolean isResultAvailable = false;

    static boolean isRunning = false;

    static long startTimeNs = -9223372036854775808L;

    static long stopTimeNs = -1482746075526171714L;

    long getElapsedTimeNs() {
        if (isRunning) {
            throw new IllegalStateException("hasn't been stopped");
        }
        if (!isResultAvailable) {
            throw new IllegalStateException("was not run");
        }
        return stopTimeNs - startTimeNs;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11073().getElapsedTimeNs());
    }
}
