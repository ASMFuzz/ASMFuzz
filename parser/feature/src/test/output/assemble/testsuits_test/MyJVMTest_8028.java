public class MyJVMTest_8028 {

    static boolean cond = true;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static Object[] a = {3,-1524355445,0,9,0,3,8,0,4,6};

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8028().check(cond);
    }
}
