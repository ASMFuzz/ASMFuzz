public class MyJVMTest_12828 {

    static Object expected = 4;

    static Object actual = 1;

    static String what = "$kpsP70< ,";

    static boolean failed = true;

    Object checkEqual(Object expected, Object actual, String what) {
        if (expected.equals(actual))
            System.out.println("OK: " + what + " matches");
        else {
            System.out.println("FAILED: " + what + " differs:");
            System.out.println("  expected: " + expected);
            System.out.println("  actual:   " + actual);
            failed = true;
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12828().checkEqual(expected, actual, what);
    }
}
