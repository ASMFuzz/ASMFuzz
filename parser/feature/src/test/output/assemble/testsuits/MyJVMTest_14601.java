public class MyJVMTest_14601 {

    static boolean isWaiting = false;

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

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14601().waitForDump();
    }
}
