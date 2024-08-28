public class MyJVMTest_10367 {

    static boolean cond = true;

    static String m = "iq2sPAkM^V";

    void pass() {
        passed++;
    }

    void fail(String msg) {
        System.out.println(msg);
        failed++;
        new Exception("Stack trace: " + msg).printStackTrace(System.out);
    }

    static int passed = 0, failed = 0;

    String check(boolean cond, String m) {
        if (cond)
            pass();
        else
            fail(m);
        return m;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10367().check(cond, m);
    }
}
