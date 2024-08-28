public class MyJVMTest_678 {

    static int a = 6, b = -1454173967, c = 0, d = 0, e = 0;

    void testDoWhileLoop() {
        final int bug;
        do {
            final int item = 0;
        } while ("a".equals("b"));
        bug = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_678().testDoWhileLoop();
    }
}
