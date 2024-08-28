public class MyJVMTest_18182 {

    static boolean b = true;

    static String msg = "R^RVv5ua0y";

    boolean assertTrue(boolean b, String msg) {
        if (!b) {
            throw new RuntimeException("Test failed: " + msg);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18182().assertTrue(b, msg);
    }
}
