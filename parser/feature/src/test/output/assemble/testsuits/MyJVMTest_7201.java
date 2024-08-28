public class MyJVMTest_7201 {

    boolean timeout() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime > TIMEOUT;
    }

    static long TIMEOUT = 300000;

    static boolean GO = false;

    static boolean STOP = false;

    static long startTime = System.currentTimeMillis();

    void run() {
        while (!GO && !timeout()) Thread.yield();
        while (!STOP && !timeout()) ;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7201().run();
    }
}
