public class MyJVMTest_4771 {

    static int sleepMillis = 2;

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
        new MyJVMTest_4771().run();
    }
}
