import java.util.concurrent.locks.LockSupport;

public class MyJVMTest_6396 {

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = -666876494;

    static Object noti = 5;

    void run() {
        started = true;
        LockSupport.parkNanos(300 * 1000000000L);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6396().run();
    }
}
