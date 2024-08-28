public class MyJVMTest_1663 {

    static String whyFailedParam1 = "8s[/w\"3-IC";

    static String whyFailedParam2Param1 = "DFI3m$cpef";

    static String whyFailedParam2Param2Param1 = "4(mh^Re(vA";

    static String whyFailedParam2Param2Param2Param1 = "xxTt0!:xbf";

    static Throwable whyFailedParam2Param2Param2 = new Throwable(whyFailedParam2Param2Param2Param1);

    static Throwable whyFailedParam2Param2 = new Throwable(whyFailedParam2Param2Param1, whyFailedParam2Param2Param2);

    static boolean whyFailedParam2Param3 = false;

    static boolean whyFailedParam2Param4 = true;

    static Throwable whyFailedParam2 = new Throwable(whyFailedParam2Param1, whyFailedParam2Param2, whyFailedParam2Param3, whyFailedParam2Param4);

    static Exception whyFailed = new Exception(whyFailedParam1, whyFailedParam2);

    static boolean theTestPassed = false;

    static boolean testGeneratedInterrupt = false;

    static String failureMessage = "";

    static Thread mainThread = null;

    Exception fail(Exception whyFailed) {
        Sysout.println("The test failed: " + whyFailed);
        Sysout.println("The test is over, hit  Ctl-C to stop Java VM");
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
        new MyJVMTest_1663().fail(whyFailed);
    }
}
