public class MyJVMTest_10777 {

    static boolean done = false;

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 9;

    static Object noti = 0;

    void run() {
        started = true;
        synchronized (lock) {
            done = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10777().run();
    }
}
