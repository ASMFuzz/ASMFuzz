public class MyJVMTest_12051 {

    static String msg = "l\\`MnUlBee";

    static String tbleParam1 = "bb!SJ75K /";

    static String tbleParam2Param1 = "Y(`+I!$rI.";

    static Throwable tbleParam2Param2 = new Throwable();

    static boolean tbleParam2Param3 = true;

    static boolean tbleParam2Param4 = false;

    static Throwable tbleParam2 = new Throwable(tbleParam2Param1, tbleParam2Param2, tbleParam2Param3, tbleParam2Param4);

    static boolean tbleParam3 = true;

    static boolean tbleParam4 = false;

    static Throwable tble = new Throwable(tbleParam1, tbleParam2, tbleParam3, tbleParam4);

    String error(String msg, Throwable tble) {
        String finalMsg = "FAILED " + (msg != null ? msg : "");
        if (tble != null) {
            throw new RuntimeException(finalMsg, tble);
        }
        throw new RuntimeException(finalMsg);
        return finalMsg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12051().error(msg, tble);
    }
}
