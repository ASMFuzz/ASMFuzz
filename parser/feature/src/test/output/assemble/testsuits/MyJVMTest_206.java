public class MyJVMTest_206 {

    static Thread mainThread = null;

    static boolean testPassed = true;

    static boolean testGeneratedInterrupt = false;

    static Thread t = null;

    void pass() {
        testPassed = true;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_206().pass();
    }
}
