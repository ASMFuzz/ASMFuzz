public class MyJVMTest_16138 {

    static int ZIP_ENTRY_NUM = 5;

    static byte[][] data = {{-56,-59,-97,59,-72,-84,118,70,-5,53},{-41,61,39,-114,120,-56,20,-21,-46,23}};

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
        new MyJVMTest_16138().run();
    }
}
