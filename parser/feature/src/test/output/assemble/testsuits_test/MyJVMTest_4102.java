import java.util.concurrent.CountDownLatch;

public class MyJVMTest_4102 {

    static CountDownLatch exitSyncObj = new CountDownLatch(1);

    static CountDownLatch startSyncObj = new CountDownLatch(1);

    void run() {
        startSyncObj.countDown();
        try {
            exitSyncObj.await();
        } catch (InterruptedException e) {
            throw new RuntimeException("Unexpected: " + e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4102().run();
    }
}
