public class MyJVMTest_13834 {

    static String eParam1 = "b8R<a<{~y#";

    static String eParam2Param1 = "mwebs>W$zK";

    static String eParam2Param2Param1Param1 = "iM.ro J}qK";

    static String eParam2Param2Param1Param2Param1 = "'_{q_Qb$1E";

    static Throwable eParam2Param2Param1Param2 = new Throwable(eParam2Param2Param1Param2Param1);

    static boolean eParam2Param2Param1Param3 = false;

    static boolean eParam2Param2Param1Param4 = false;

    static Throwable eParam2Param2Param1 = new Throwable(eParam2Param2Param1Param1, eParam2Param2Param1Param2, eParam2Param2Param1Param3, eParam2Param2Param1Param4);

    static Throwable eParam2Param2 = new Throwable(eParam2Param2Param1);

    static boolean eParam2Param3 = false;

    static boolean eParam2Param4 = true;

    static Throwable eParam2 = new Throwable(eParam2Param1, eParam2Param2, eParam2Param3, eParam2Param4);

    static boolean eParam3 = true;

    static boolean eParam4 = false;

    static Error e = new Error(eParam1, eParam2, eParam3, eParam4);

    static String expected = "nfK`4U%Y1i";

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
        new MyJVMTest_13834().checkMsg(e, expected);
    }
}
