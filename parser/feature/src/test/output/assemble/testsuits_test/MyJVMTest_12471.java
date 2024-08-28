public class MyJVMTest_12471 {

    static String msg = "Do%U3P#.D>";

    static boolean ok = true;

    static String m = "?J1|{:Ilfu";

    boolean check(String msg, boolean ok) {
        System.err.println(msg + ": " + (ok ? "ok" : "failed"));
        if (!ok)
            throw new AssertionError(msg);
        return ok;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12471().check(msg, ok);
    }
}
