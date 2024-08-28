import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class MyJVMTest_5310 {

    static StampedLock lock = new StampedLock();

    static int x = -624242006, y = -1857248034;

    void WLI_Us() {
        try {
            StampedLock lock = this.lock;
            long stamp = lock.writeLockInterruptibly();
            x = 1;
            y = 2;
            lock.unlock(stamp);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5310().WLI_Us();
    }
}
