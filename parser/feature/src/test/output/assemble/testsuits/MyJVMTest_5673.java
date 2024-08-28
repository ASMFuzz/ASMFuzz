public class MyJVMTest_5673 {

    static boolean condition = false;

    static String msg = "C[?Nph\\CIU";

    void log(String msg) {
        System.out.println("[" + scenario + "] " + msg);
    }

    static String scenario = "H^Sm:#RIf2";

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
        new MyJVMTest_5673().assertTrue(condition, msg);
    }
}
