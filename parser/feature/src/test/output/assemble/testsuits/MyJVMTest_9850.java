public class MyJVMTest_9850 {

    static int a = 0, b = 0, c = 0, d = 1, e = 8;

    void testDoWhileLoop() {
        final int bug;
        do {
            final int item = 0;
        } while ("a".equals("b"));
        bug = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9850().testDoWhileLoop();
    }
}
