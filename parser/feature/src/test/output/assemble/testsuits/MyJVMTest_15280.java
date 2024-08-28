public class MyJVMTest_15280 {

    static Thread theThread = null;

    static Object lock = 0;

    static Object noti = 7;

    void run() {
        synchronized (theThread) {
            theThread.notify();
        }
        theThread.start();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15280().run();
    }
}
