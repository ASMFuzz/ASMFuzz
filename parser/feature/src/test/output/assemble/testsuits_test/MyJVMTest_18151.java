public class MyJVMTest_18151 {

    static String tParam1 = "X_E7=e[N+X";

    static String tParam2Param1Param1 = "[|$uzf2,,8";

    static String tParam2Param1Param2Param1 = "s{gg+F$HsO";

    static String tParam2Param1Param2Param2Param1 = "iI\"e?vqx|`";

    static Throwable tParam2Param1Param2Param2 = new Throwable(tParam2Param1Param2Param2Param1);

    static boolean tParam2Param1Param2Param3 = false;

    static boolean tParam2Param1Param2Param4 = true;

    static Throwable tParam2Param1Param2 = new Throwable(tParam2Param1Param2Param1, tParam2Param1Param2Param2, tParam2Param1Param2Param3, tParam2Param1Param2Param4);

    static Throwable tParam2Param1 = new Throwable(tParam2Param1Param1, tParam2Param1Param2);

    static Throwable tParam2 = new Throwable(tParam2Param1);

    static boolean tParam3 = false;

    static boolean tParam4 = false;

    static Throwable t = new Throwable(tParam1, tParam2, tParam3, tParam4);

    static String msg = "Hq{&uTw|th";

    static String causeParam1 = "dgp>9OkdR#";

    static String causeParam2Param1 = "]/>U\\q}f'`";

    static String causeParam2Param2Param1 = "{B+qQo`S\\^";

    static String causeParam2Param2Param2Param1 = "om\\qJ2W$^A";

    static String causeParam2Param2Param2Param2Param1Param1 = ",rcw&NdmkL";

    static Throwable causeParam2Param2Param2Param2Param1Param2 = new Throwable();

    static Throwable causeParam2Param2Param2Param2Param1 = new Throwable(causeParam2Param2Param2Param2Param1Param1, causeParam2Param2Param2Param2Param1Param2);

    static Throwable causeParam2Param2Param2Param2 = new Throwable(causeParam2Param2Param2Param2Param1);

    static boolean causeParam2Param2Param2Param3 = true;

    static boolean causeParam2Param2Param2Param4 = true;

    static Throwable causeParam2Param2Param2 = new Throwable(causeParam2Param2Param2Param1, causeParam2Param2Param2Param2, causeParam2Param2Param2Param3, causeParam2Param2Param2Param4);

    static boolean causeParam2Param2Param3 = true;

    static boolean causeParam2Param2Param4 = false;

    static Throwable causeParam2Param2 = new Throwable(causeParam2Param2Param1, causeParam2Param2Param2, causeParam2Param2Param3, causeParam2Param2Param4);

    static boolean causeParam2Param3 = true;

    static boolean causeParam2Param4 = true;

    static Throwable causeParam2 = new Throwable(causeParam2Param1, causeParam2Param2, causeParam2Param3, causeParam2Param4);

    static boolean causeParam3 = false;

    static boolean causeParam4 = false;

    static Throwable cause = new Throwable(causeParam1, causeParam2, causeParam3, causeParam4);

    Throwable check(Throwable t, String msg, Throwable cause) throws Exception {
        String tmsg = t.getMessage();
        if (msg == null ? tmsg != null : !msg.equals(tmsg)) {
            throw new RuntimeException("message does not match");
        }
        if (t.getClass().getField("detail").get(t) != cause) {
            throw new RuntimeException("detail field does not match");
        }
        if (t.getCause() != cause) {
            throw new RuntimeException("getCause value does not match");
        }
        try {
            t.initCause(cause);
            throw new RuntimeException("initCause succeeded");
        } catch (IllegalStateException e) {
        }
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18151().check(t, msg, cause);
    }
}
