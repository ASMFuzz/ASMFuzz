public class MyJVMTest_224 {

    static int a = 838288559, b = 8, c = -1537942621, d = -1200463673, e = 1845358763;

    void testForLoop() {
        final int bug;
        for (; "a".equals("b"); ) {
            final int item = 0;
        }
        bug = 0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_224().testForLoop();
    }
}
