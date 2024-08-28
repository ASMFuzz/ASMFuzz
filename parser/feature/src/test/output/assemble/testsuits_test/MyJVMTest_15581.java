public class MyJVMTest_15581 {

    boolean timeout() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime > TIMEOUT;
    }

    static long TIMEOUT = 300000;

    static Object stopLine = new Object();

    static int oopsCounter = 0;

    static long startTime = System.currentTimeMillis();

    void run() {
        synchronized (stopLine) {
            try {
                stopLine.wait();
            } catch (InterruptedException oops) {
                oopsCounter++;
                return;
            }
        }
        while (!timeout()) continue;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15581().run();
    }
}
