public class MyJVMTest_17422 {

    static boolean isResultAvailable = true;

    static boolean isRunning = false;

    static long startTimeNs = -3471108298739290157L;

    void start() {
        startTimeNs = System.nanoTime();
        isRunning = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17422().start();
    }
}
