public class MyJVMTest_15109 {

    static boolean condition = true;

    static String msg = "_`xA&qS.vM";

    void log(String msg) {
        System.out.println("[" + scenario + "] " + msg);
    }

    static String scenario = "%O*FdtHoCn";

    String assertTrue(boolean condition, String msg) {
        if (!condition) {
            log(" FAILED -  ERROR: " + msg);
            throw new RuntimeException("[" + scenario + "] " + msg);
        } else {
            log(" PASSED.");
        }
        return msg;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15109().assertTrue(condition, msg);
    }
}
