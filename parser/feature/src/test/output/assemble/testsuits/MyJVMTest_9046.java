public class MyJVMTest_9046 {

    static String tParam1 = "|alexQL\\%q";

    static String tParam2Param1Param1Param1 = "%t`aeS@5?m";

    static Throwable tParam2Param1Param1Param2 = new Throwable();

    static boolean tParam2Param1Param1Param3 = true;

    static boolean tParam2Param1Param1Param4 = true;

    static Throwable tParam2Param1Param1 = new Throwable(tParam2Param1Param1Param1, tParam2Param1Param1Param2, tParam2Param1Param1Param3, tParam2Param1Param1Param4);

    static Throwable tParam2Param1 = new Throwable(tParam2Param1Param1);

    static Throwable tParam2 = new Throwable(tParam2Param1);

    static Throwable t = new Throwable(tParam1, tParam2);

    static String msg = "/~NtYV1{Eq";

    static String causeParam1Param1 = "(,EOCt.JA[";

    static Throwable causeParam1 = new Throwable(causeParam1Param1);

    static Throwable cause = new Throwable(causeParam1);

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
        new MyJVMTest_9046().check(t, msg, cause);
    }
}
