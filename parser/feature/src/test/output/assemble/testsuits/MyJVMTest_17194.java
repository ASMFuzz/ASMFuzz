public class MyJVMTest_17194 {

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = -680795368;

    static Object noti = 5;

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
        new MyJVMTest_17194().run();
    }
}
