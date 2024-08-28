public class MyJVMTest_6099 {

    static boolean test = true;

    static String what = "dJ}IRG[qbQ";

    static String prefix = "7p8)WpBMwR";

    static String toString = "'zv[rpZTCL";

    boolean assertTrue(boolean test, String what, String prefix) {
        if (!test) {
            throw new RuntimeException("Expected true for " + what);
        }
        System.out.println(prefix + "Got expected " + what + ": " + test);
        return test;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6099().assertTrue(test, what, prefix);
    }
}
