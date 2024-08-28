import java.util.concurrent.locks.LockSupport;

public class MyJVMTest_15878 {

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 0;

    static Object noti = 6;

    void run() {
        started = true;
        LockSupport.parkNanos(300 * 1000000000L);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15878().run();
    }
}
