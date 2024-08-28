public class MyJVMTest_9375 {

    static int a = 6, b = 4, c = 0, d = 742087661, e = 0;

    void testForLoop() {
        final int bug;
        for (; "a".equals("b"); ) {
            final int item = 0;
        }
        bug = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9375().testForLoop();
    }
}
