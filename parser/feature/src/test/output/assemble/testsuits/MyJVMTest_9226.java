public class MyJVMTest_9226 {

    static boolean theTestPassed = false;

    static boolean testGeneratedInterrupt = false;

    static Thread mainThread = null;

    void pass() {
        theTestPassed = true;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9226().pass();
    }
}
