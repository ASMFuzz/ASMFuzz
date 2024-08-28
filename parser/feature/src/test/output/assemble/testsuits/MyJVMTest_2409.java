import java.util.concurrent.CountDownLatch;

public class MyJVMTest_2409 {

    static ThreadGroup THREAD_GROUP = new ThreadGroup("Latched Threads");

    static CountDownLatch latch = new CountDownLatch(1);

    void awaitStarted() throws InterruptedException {
        latch.await();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2409().awaitStarted();
    }
}
