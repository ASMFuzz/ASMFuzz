public class MyJVMTest_1847 {

    static boolean isResultAvailable = true;

    static boolean isRunning = true;

    static long startTimeNs = -2433002740812729716L;

    static long stopTimeNs = -9223372036854775808L;

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
        System.out.println(new MyJVMTest_1847().getElapsedTimeNs());
    }
}
