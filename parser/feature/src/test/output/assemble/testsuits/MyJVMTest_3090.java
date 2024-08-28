import java.util.concurrent.locks.LockSupport;

public class MyJVMTest_3090 {

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 0;

    static Object noti = 1572906801;

    void run() {
        started = true;
        LockSupport.park();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3090().run();
    }
}
