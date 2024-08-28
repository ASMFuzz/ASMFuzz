public class MyJVMTest_9064 {

    static String whyFailedParam1 = "+I8?8q%KIX";

    static String whyFailedParam2Param1Param1 = "*s)oc}rY3:";

    static Throwable whyFailedParam2Param1Param2 = new Throwable();

    static Throwable whyFailedParam2Param1 = new Throwable(whyFailedParam2Param1Param1, whyFailedParam2Param1Param2);

    static Throwable whyFailedParam2 = new Throwable(whyFailedParam2Param1);

    static Exception whyFailed = new Exception(whyFailedParam1, whyFailedParam2);

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
        new MyJVMTest_9064().fail(whyFailed);
    }
}
