public class MyJVMTest_7862 {

    static boolean isResultAvailable = false;

    static boolean isRunning = false;

    static long startTimeNs = 9223372036854775807L;

    void start() {
        startTimeNs = System.nanoTime();
        isRunning = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7862().start();
    }
}
