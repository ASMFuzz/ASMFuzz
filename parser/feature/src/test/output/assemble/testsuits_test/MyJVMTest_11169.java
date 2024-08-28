public class MyJVMTest_11169 {

    static int a = 5, b = 5, c = 3, d = 9, e = 9;

    void testWhileLoop() {
        final int bug;
        while ("a".equals("b")) {
            final int item = 0;
        }
        bug = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11169().testWhileLoop();
    }
}
