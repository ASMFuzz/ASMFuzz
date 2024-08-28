import java.lang.ref.*;

public class MyJVMTest_10693 {

    static ReferenceQueue<Object> queue = new ReferenceQueue<Object>();

    static Reference<Object> ref = null;

    static int iterations = 1000;

    void run() throws InterruptedException {
        System.gc();
        for (int i = 0; i < iterations; i++) {
            System.gc();
            if (ref.isEnqueued()) {
                break;
            }
            Thread.sleep(100);
        }
        if (ref.isEnqueued() == false) {
            System.out.println("Reference not enqueued yet");
            return;
        }
        if (ref.enqueue() == true) {
            throw new RuntimeException("Error: enqueue() returned true;" + " expected false");
        }
        if (queue.poll() == null) {
            throw new RuntimeException("Error: poll() returned null;" + " expected ref object");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10693().run();
    }
}
