public class MyJVMTest_5834 {

    static Thread theThread = null;

    static Object lock = 1;

    static Object noti = 4;

    void run() {
        synchronized (theThread) {
            theThread.notify();
        }
        theThread.start();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5834().run();
    }
}
