public class MyJVMTest_3579 {

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
        new MyJVMTest_3579().endJittedHelperThread();
    }
}
