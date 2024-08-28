public class MyJVMTest_4449 {

    static String eParam1 = "- O&So`rBm";

    static String eParam2Param1Param1Param1 = "at1:kw{^~O";

    static String eParam2Param1Param1Param2Param1 = "J|i`J,&}u4";

    static String eParam2Param1Param1Param2Param2Param1 = "r0q%=9h]^Y";

    static Throwable eParam2Param1Param1Param2Param2Param2 = new Throwable();

    static boolean eParam2Param1Param1Param2Param2Param3 = false;

    static boolean eParam2Param1Param1Param2Param2Param4 = true;

    static Throwable eParam2Param1Param1Param2Param2 = new Throwable(eParam2Param1Param1Param2Param2Param1, eParam2Param1Param1Param2Param2Param2, eParam2Param1Param1Param2Param2Param3, eParam2Param1Param1Param2Param2Param4);

    static Throwable eParam2Param1Param1Param2 = new Throwable(eParam2Param1Param1Param2Param1, eParam2Param1Param1Param2Param2);

    static boolean eParam2Param1Param1Param3 = false;

    static boolean eParam2Param1Param1Param4 = false;

    static Throwable eParam2Param1Param1 = new Throwable(eParam2Param1Param1Param1, eParam2Param1Param1Param2, eParam2Param1Param1Param3, eParam2Param1Param1Param4);

    static Throwable eParam2Param1 = new Throwable(eParam2Param1Param1);

    static Throwable eParam2 = new Throwable(eParam2Param1);

    static boolean eParam3 = false;

    static boolean eParam4 = false;

    static Error e = new Error(eParam1, eParam2, eParam3, eParam4);

    static String expected = "hG|)\\8:6~w";

    String checkMsg(Error e, String expected) throws Exception {
        String errorMsg = e.getMessage();
        if (errorMsg == null) {
            throw new RuntimeException("Caught AbstractMethodError with empty message.");
        } else if (errorMsg.contains(expected)) {
            System.out.println("Passed with message: " + errorMsg);
        } else {
            System.out.println("Expected method to be printed as \"" + expected + "\"\n" + "in exception message:  " + errorMsg);
            throw new RuntimeException("Method not printed as expected.");
        }
        return errorMsg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4449().checkMsg(e, expected);
    }
}
