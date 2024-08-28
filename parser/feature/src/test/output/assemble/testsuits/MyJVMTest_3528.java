public class MyJVMTest_3528 {

    static Thread theThread = null;

    static boolean started = false;

    static Object lock = -1383382951;

    static Object noti = 4;

    void run() {
        started = true;
        try {
            Thread.sleep(5 * 60 * 1000);
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3528().run();
    }
}
