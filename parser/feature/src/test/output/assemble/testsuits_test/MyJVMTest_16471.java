public class MyJVMTest_16471 {

    static boolean theTestPassed = false;

    static boolean testGeneratedInterrupt = true;

    static Thread mainThread = null;

    void pass() {
        theTestPassed = true;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16471().pass();
    }
}
