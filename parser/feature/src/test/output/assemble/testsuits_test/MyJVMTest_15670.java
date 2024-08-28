public class MyJVMTest_15670 {

    static boolean b = false;

    static String msg = "Cr{6]kuP. ";

    static int assertionCount = 2;

    boolean assertTrue(boolean b, String msg) {
        assertionCount++;
        if (!b) {
            throw new AssertionError(msg);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15670().assertTrue(b, msg);
    }
}
