public class MyJVMTest_8560 {

    static String tParam1 = "Hbc,o=s6/P";

    static Throwable tParam2Param1 = new Throwable();

    static Throwable tParam2 = new Throwable(tParam2Param1);

    static Throwable t = new Throwable(tParam1, tParam2);

    static String msg = "t[;z)RzoK%";

    static Throwable causeParam1 = new Throwable();

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
        new MyJVMTest_8560().check(t, msg, cause);
    }
}
