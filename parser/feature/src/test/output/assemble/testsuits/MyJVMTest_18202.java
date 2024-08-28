import java.lang.management.*;
import java.util.concurrent.*;
import javax.management.*;

public class MyJVMTest_18202 {

    static int semaphoreParam1 = 55;

    static Semaphore semaphore = new Semaphore(semaphoreParam1);

    Object block(Semaphore semaphore) {
        Object lock = new Object();
        synchronized (lock) {
            try {
                semaphore.release();
                lock.wait();
            } catch (InterruptedException e) {
                System.out.println("TEST INCORRECT: lock interrupted:");
                e.printStackTrace(System.out);
                System.exit(1);
            }
        }
        return lock;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18202().block(semaphore);
    }
}
