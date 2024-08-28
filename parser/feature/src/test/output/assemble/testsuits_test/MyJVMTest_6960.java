public class MyJVMTest_6960 {

    static boolean theTestPassed = true;

    static boolean testGeneratedInterrupt = true;

    static Thread mainThread = null;

    void pass() {
        theTestPassed = true;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6960().pass();
    }
}
