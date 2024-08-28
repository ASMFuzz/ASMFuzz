public class MyJVMTest_14856 {

    static String msg = "D*a?s?IV?f";

    static boolean ok = true;

    boolean check(String msg, boolean ok) {
        System.err.println(msg + ": " + (ok ? "ok" : "failed"));
        if (!ok)
            throw new AssertionError(msg);
        return ok;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14856().check(msg, ok);
    }
}
