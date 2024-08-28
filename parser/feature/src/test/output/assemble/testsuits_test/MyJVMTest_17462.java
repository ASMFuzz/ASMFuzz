public class MyJVMTest_17462 {

    static Object x = 6;

    static Object y = 0;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static Object[] a = {6,-690907299,3,0,-391939543,7,2,0,3,0};

    static int passed = 0, failed = 0;

    Object equal(Object x, Object y) {
        if (x == null ? y == null : x.equals(y))
            pass();
        else {
            System.out.println(x + " not equal to " + y);
            fail();
        }
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17462().equal(x, y);
    }
}
