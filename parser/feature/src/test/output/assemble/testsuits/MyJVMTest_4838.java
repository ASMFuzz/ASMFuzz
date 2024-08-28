public class MyJVMTest_4838 {

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 9;

    static Object noti = 9;

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
        new MyJVMTest_4838().run();
    }
}
