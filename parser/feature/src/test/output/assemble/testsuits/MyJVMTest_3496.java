public class MyJVMTest_3496 {

    static Object expected = 5;

    static Object actual = 7;

    static String what = "YNPx1XZ&Ml";

    static boolean failed = false;

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
        new MyJVMTest_3496().checkEqual(expected, actual, what);
    }
}
