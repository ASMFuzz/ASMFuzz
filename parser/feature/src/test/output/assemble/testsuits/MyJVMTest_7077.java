public class MyJVMTest_7077 {

    static String whyFailed = "oH>v;j<[t)";

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
        new MyJVMTest_7077().fail(whyFailed);
    }
}
