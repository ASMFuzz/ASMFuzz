public class MyJVMTest_3344 {

    static boolean cond = false;

    static String msg = "2;b>cYm@o\"";

    boolean assertTrue(boolean cond, String msg) {
        if (!cond)
            throw new AssertionError(msg);
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3344().assertTrue(cond, msg);
    }
}
