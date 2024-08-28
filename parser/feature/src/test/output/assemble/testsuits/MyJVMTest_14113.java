public class MyJVMTest_14113 {

    static boolean theTestPassed = false;

    static boolean testGeneratedInterrupt = true;

    static Thread mainThread = null;

    void fail() {
        theTestPassed = false;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14113().fail();
    }
}
