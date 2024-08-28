public class MyJVMTest_14324 {

    void waitForDump() {
        synchronized (this) {
            isWaiting = true;
            notifyAll();
            while (isWaiting) {
                try {
                    wait(0, 0);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static boolean isWaiting = false;

    static Thread jittedThread = null;

    void configureJittedHelperThread() {
        jittedThread = new Thread() {

            public void run() {
                waitForDump();
            }
        };
        jittedThread.start();
        synchronized (this) {
            while (!isWaiting) {
                try {
                    wait(0, 0);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14324().run();
    }
}
