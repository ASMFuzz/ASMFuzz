public class MyJVMTest_12914 {

    static boolean isWaiting = false;

    static Thread jittedThread = null;

    void endJittedHelperThread() {
        synchronized (this) {
            isWaiting = false;
            notifyAll();
        }
        try {
            jittedThread.join();
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12914().endJittedHelperThread();
    }
}
