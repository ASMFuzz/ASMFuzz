public class MyJVMTest_6200 {

    static boolean cond = true;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static int pseudodelay = 9;

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6200().check(cond);
    }
}
