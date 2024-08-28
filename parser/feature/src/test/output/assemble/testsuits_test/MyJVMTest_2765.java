public class MyJVMTest_2765 {

    static String whyFailed = "RMFwl'XdQD";

    static boolean theTestPassed = false;

    static boolean testGeneratedInterrupt = false;

    static String failureMessage = "";

    static Thread mainThread = null;

    String fail(String whyFailed) {
        theTestPassed = false;
        testGeneratedInterrupt = true;
        failureMessage = whyFailed;
        mainThread.interrupt();
        return whyFailed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2765().fail(whyFailed);
    }
}
