public class MyJVMTest_10167 {

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

    void run() {
        waitForDump();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10167().run();
    }
}
