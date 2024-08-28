public class MyJVMTest_6545 {

    static Object wakeup = new Object();

    static Thread tdThread = null;

    void run() {
        synchronized (wakeup) {
            tdThread = Thread.currentThread();
            wakeup.notify();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6545().run();
    }
}
