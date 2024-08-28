public class MyJVMTest_16038 {

    static Object wakeup = new Object();

    static Thread tdThread = null;

    void run() {
        synchronized (wakeup) {
            tdThread = Thread.currentThread();
            wakeup.notify();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16038().run();
    }
}
