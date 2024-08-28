public class MyJVMTest_8590 {

    static boolean b = true;

    static String msg = "+n{%U2^)BN";

    boolean assertTrue(boolean b, String msg) {
        if (!b) {
            throw new RuntimeException("Test failed: " + msg);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8590().assertTrue(b, msg);
    }
}
