public class MyJVMTest_1398 {

    static String eParam1Param1 = "^7B-}Hb`jd";

    static String eParam1Param2Param1 = ")@^g66r\\f ";

    static Throwable eParam1Param2 = new Throwable(eParam1Param2Param1);

    static boolean eParam1Param3 = false;

    static boolean eParam1Param4 = true;

    static Throwable eParam1 = new Throwable(eParam1Param1, eParam1Param2, eParam1Param3, eParam1Param4);

    static Exception e = new Exception(eParam1);

    static boolean failed = false;

    static Exception failureException = null;

    Exception setStatusFailed(Exception e) {
        if (!failed) {
            failureException = e;
            failed = true;
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1398().setStatusFailed(e);
    }
}
