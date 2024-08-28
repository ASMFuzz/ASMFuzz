public class MyJVMTest_9357 {

    static Thread mainThread = null;

    static boolean testPassed = false;

    static boolean testGeneratedInterrupt = false;

    static Thread t = null;

    void pass() {
        testPassed = true;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9357().pass();
    }
}
