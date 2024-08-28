import java.util.concurrent.CountDownLatch;

public class MyJVMTest_9598 {

    static CountDownLatch exitSyncObj = new CountDownLatch(1);

    static CountDownLatch startSyncObj = new CountDownLatch(1);

    void run() {
        try {
            startSyncObj.countDown();
            try {
                exitSyncObj.await();
            } catch (InterruptedException e) {
            }
        } catch (ThreadDeath td) {
        } catch (NoClassDefFoundError ncdfe) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9598().run();
    }
}
