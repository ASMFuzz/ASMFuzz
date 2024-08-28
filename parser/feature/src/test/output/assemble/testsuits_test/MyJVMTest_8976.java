public class MyJVMTest_8976 {

    static boolean expr = false;

    boolean assertTrue(boolean expr) {
        if (!expr)
            throw new RuntimeException("assertion failed");
        return expr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8976().assertTrue(expr);
    }
}
