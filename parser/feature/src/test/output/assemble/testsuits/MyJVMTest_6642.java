public class MyJVMTest_6642 {

    static int ZIP_ENTRY_NUM = 5;

    static byte[][] data = {{116,3,109,116,30,-105,-18,-76,-124,72},{14,-64,-43,-58,124,-87,-66,74,-19,14}};

    static int sleepMillis = 0;

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
        new MyJVMTest_6642().run();
    }
}
