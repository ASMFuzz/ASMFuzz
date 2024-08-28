public class MyJVMTest_16595 {

    static String whyFailed = "{Sd(x[cD2%";

    static boolean theTestPassed = false;

    static boolean testGeneratedInterrupt = false;

    static String failureMessage = "";

    static Thread mainThread = null;

    String fail(String whyFailed) {
        if (mainThread == Thread.currentThread()) {
            throw new RuntimeException(whyFailed);
        }
        theTestPassed = false;
        testGeneratedInterrupt = true;
        failureMessage = whyFailed;
        mainThread.interrupt();
        return whyFailed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16595().fail(whyFailed);
    }
}
