public class MyJVMTest_8968 {

    static Thread mainThread = null;

    static boolean testPassed = false;

    static boolean testGeneratedInterrupt = true;

    void fail() {
        testPassed = false;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8968().fail();
    }
}
