public class MyJVMTest_1169 {

    static boolean cond = false;

    static String m = "l|yi(0'0 \"";

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
        new MyJVMTest_1169().check(cond, m);
    }
}
