import java.util.concurrent.atomic.*;

public class MyJVMTest_10272 {

    static Object sink = 8;

    static Throwable failed = null;

    static AtomicInteger allocated = new AtomicInteger();

    void workload() {
        try {
            sink = new Object();
            allocated.incrementAndGet();
            Thread.sleep(3600 * 1000);
        } catch (Throwable e) {
            failed = e;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10272().workload();
    }
}
