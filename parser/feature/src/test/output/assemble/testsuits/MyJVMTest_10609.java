public class MyJVMTest_10609 {

    static String eParam1 = "X\\]u9nL?_k";

    static Throwable eParam2 = new Throwable();

    static boolean eParam3 = false;

    static boolean eParam4 = true;

    static Exception e = new Exception(eParam1, eParam2, eParam3, eParam4);

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
        new MyJVMTest_10609().setStatusFailed(e);
    }
}
