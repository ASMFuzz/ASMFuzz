import java.util.concurrent.CountDownLatch;

public class MyJVMTest_2011 {

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
        new MyJVMTest_2011().run();
    }
}
