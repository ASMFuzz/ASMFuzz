import java.util.concurrent.atomic.*;

public class MyJVMTest_1078 {

    static Object sink = -2084531671;

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
        new MyJVMTest_1078().workload();
    }
}
