import javax.management.*;
import javax.management.timer.*;

public class MyJVMTest_15384 {

    static Object o = 0;

    static boolean gotLock = false;

    void run() {
        System.out.println("BadBoy-run: keep synchronization lock forever!");
        synchronized (o) {
            synchronized (this) {
                gotLock = true;
                this.notify();
            }
            try {
                Thread.sleep(10000000);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15384().run();
    }
}
