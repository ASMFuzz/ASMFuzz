public class MyJVMTest_13328 {

    boolean timeout() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        return elapsedTime > TIMEOUT;
    }

    static long TIMEOUT = 300000;

    static long startTime = System.currentTimeMillis();

    void run() {
        while (!timeout()) continue;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13328().run();
    }
}
