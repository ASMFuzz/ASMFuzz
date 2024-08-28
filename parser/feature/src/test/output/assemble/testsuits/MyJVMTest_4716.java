public class MyJVMTest_4716 {

    static boolean theTestPassed = true;

    static boolean testGeneratedInterrupt = false;

    static Thread mainThread = null;

    void fail() {
        theTestPassed = false;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4716().fail();
    }
}
