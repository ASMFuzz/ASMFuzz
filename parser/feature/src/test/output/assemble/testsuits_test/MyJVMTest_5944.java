public class MyJVMTest_5944 {

    static boolean isResultAvailable = false;

    static boolean isRunning = false;

    static long stopTimeNs = 9223372036854775807L;

    void stop() {
        if (!isRunning) {
            throw new IllegalStateException(" hasn't been started");
        }
        stopTimeNs = System.nanoTime();
        isRunning = false;
        isResultAvailable = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5944().stop();
    }
}
