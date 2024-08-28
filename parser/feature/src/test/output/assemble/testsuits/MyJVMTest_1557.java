public class MyJVMTest_1557 {

    static boolean done = false;

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 0;

    static Object noti = 9;

    void run() {
        started = true;
        synchronized (lock) {
            done = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1557().run();
    }
}
