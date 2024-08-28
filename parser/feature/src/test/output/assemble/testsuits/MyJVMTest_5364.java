public class MyJVMTest_5364 {

    static String whyFailedParam1 = "4q9hM)jh-y";

    static Exception whyFailed = new Exception(whyFailedParam1);

    static boolean theTestPassed = false;

    static boolean testGeneratedInterrupt = false;

    static String failureMessage = "";

    static Thread mainThread = null;

    Exception fail(Exception whyFailed) {
        System.out.println("The test failed: " + whyFailed);
        System.out.println("The test is over, hit  Ctl-C to stop Java VM");
        if (mainThread == Thread.currentThread()) {
            throw new RuntimeException(whyFailed);
        }
        theTestPassed = false;
        testGeneratedInterrupt = true;
        failureMessage = whyFailed.toString();
        mainThread.interrupt();
        return whyFailed;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5364().fail(whyFailed);
    }
}
