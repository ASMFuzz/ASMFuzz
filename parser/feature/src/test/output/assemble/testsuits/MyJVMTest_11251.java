import java.util.concurrent.CountDownLatch;

public class MyJVMTest_11251 {

    Runnable countDownTask(final CountDownLatch latch) {
        return new Runnable() {

            public void run() {
                latch.countDown();
                if (latch.getCount() <= 0)
                    throw new RuntimeException("done");
            }
        };
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11251().run();
    }
}
