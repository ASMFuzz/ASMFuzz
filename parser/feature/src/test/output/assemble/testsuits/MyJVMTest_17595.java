public class MyJVMTest_17595 {

    static boolean cond = false;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static Object[] a = {3,4,0,-1488742686,200873625,-792140786,3,4,7,0};

    static int passed = 0, failed = 0;

    boolean check(boolean cond) {
        if (cond)
            pass();
        else
            fail();
        return cond;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17595().check(cond);
    }
}
