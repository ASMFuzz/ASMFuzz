public class MyJVMTest_15396 {

    static boolean isResultAvailable = true;

    static boolean isRunning = false;

    static long stopTimeNs = -4182905129746298421L;

    void stop() {
        if (!isRunning) {
            throw new IllegalStateException(" hasn't been started");
        }
        stopTimeNs = System.nanoTime();
        isRunning = false;
        isResultAvailable = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15396().stop();
    }
}
