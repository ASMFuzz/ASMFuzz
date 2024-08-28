public class MyJVMTest_701 {

    static Thread mainThread = null;

    static boolean testPassed = true;

    static boolean testGeneratedInterrupt = false;

    static Thread t = null;

    void fail() {
        testPassed = false;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_701().fail();
    }
}
