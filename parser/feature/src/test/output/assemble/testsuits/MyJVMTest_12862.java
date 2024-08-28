public class MyJVMTest_12862 {

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = 1;

    static Object noti = 0;

    void run() {
        started = true;
        try {
            Thread.sleep(5 * 60 * 1000);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12862().run();
    }
}
