public class MyJVMTest_14238 {

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 1409260555;

    static Object noti = 7;

    void run() {
        started = true;
        synchronized (noti) {
            try {
                noti.wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14238().run();
    }
}
