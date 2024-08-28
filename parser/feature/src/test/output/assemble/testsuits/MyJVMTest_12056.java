public class MyJVMTest_12056 {

    static String whyFailed = "NU+ryaeHhn";

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
        new MyJVMTest_12056().fail(whyFailed);
    }
}
