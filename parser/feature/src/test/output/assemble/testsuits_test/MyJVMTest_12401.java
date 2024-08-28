import java.util.concurrent.locks.LockSupport;

public class MyJVMTest_12401 {

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 7;

    static Object noti = 0;

    void run() {
        started = true;
        LockSupport.park();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12401().run();
    }
}
