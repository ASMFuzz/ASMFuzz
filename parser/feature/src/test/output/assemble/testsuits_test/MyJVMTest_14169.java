public class MyJVMTest_14169 {

    static int sleepMillis = 1134257067;

    static boolean keepRunning = true;

    void run() {
        while (keepRunning) {
            System.gc();
            try {
                wait(sleepMillis);
            } catch (InterruptedException e) {
                System.out.println("GCing thread unexpectedly interrupted");
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14169().run();
    }
}
