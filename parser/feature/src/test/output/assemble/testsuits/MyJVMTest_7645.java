public class MyJVMTest_7645 {

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 4;

    static Object noti = 0;

    void run() {
        started = true;
        synchronized (noti) {
            try {
                noti.wait(5 * 60 * 1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7645().run();
    }
}
