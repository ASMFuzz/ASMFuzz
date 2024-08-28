public class MyJVMTest_6197 {

    static boolean b = false;

    static String msg = "|GVP(,!RLO";

    static int assertionCount = 1028690277;

    boolean assertTrue(boolean b, String msg) {
        assertionCount++;
        if (!b) {
            throw new AssertionError(msg);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6197().assertTrue(b, msg);
    }
}
