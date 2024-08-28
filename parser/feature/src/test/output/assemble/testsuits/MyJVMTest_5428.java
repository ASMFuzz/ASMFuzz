public class MyJVMTest_5428 {

    static String msg = "L1X#M?ab>e";

    static boolean ok = false;

    boolean check(String msg, boolean ok) {
        System.err.println(msg + ": " + (ok ? "ok" : "failed"));
        if (!ok)
            throw new AssertionError(msg);
        return ok;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5428().check(msg, ok);
    }
}
