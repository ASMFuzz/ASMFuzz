public class MyJVMTest_1020 {

    static int ZIP_ENTRY_NUM = 5;

    static byte[][] data = {{-8,-24,-7,-125,72,-69,-98,10,47,-81},{-56,79,-36,98,109,-56,25,-7,14,89}};

    static int sleepMillis = 6;

    static boolean keepRunning = true;

    void shutDown() {
        keepRunning = false;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1020().shutDown();
    }
}
