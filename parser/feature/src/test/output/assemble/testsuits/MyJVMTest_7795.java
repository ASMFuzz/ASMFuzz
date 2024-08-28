public class MyJVMTest_7795 {

    static boolean expr = true;

    boolean assertTrue(boolean expr) {
        if (!expr)
            throw new RuntimeException("assertion failed");
        return expr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7795().assertTrue(expr);
    }
}
