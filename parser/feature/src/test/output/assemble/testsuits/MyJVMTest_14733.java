import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class MyJVMTest_14733 {

    static StampedLock lock = new StampedLock();

    static int x = 5, y = 2;

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
        new MyJVMTest_14733().WLI_Us();
    }
}
