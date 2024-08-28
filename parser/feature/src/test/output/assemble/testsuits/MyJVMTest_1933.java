public class MyJVMTest_1933 {

    static int a = 0, b = 0, c = 2, d = 0, e = 6;

    void testWhileLoop() {
        final int bug;
        while ("a".equals("b")) {
            final int item = 0;
        }
        bug = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1933().testWhileLoop();
    }
}
