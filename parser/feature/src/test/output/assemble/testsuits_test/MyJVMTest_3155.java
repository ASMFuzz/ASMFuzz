public class MyJVMTest_3155 {

    static String msg = "Za9_F&T/NE";

    static boolean ok = false;

    static String m = "$}2\"l^i=D}";

    boolean check(String msg, boolean ok) {
        System.err.println(msg + ": " + (ok ? "ok" : "failed"));
        if (!ok)
            throw new AssertionError(msg);
        return ok;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3155().check(msg, ok);
    }
}
