public class MyJVMTest_7900 {

    static Object x = 9;

    static Object y = 1362061689;

    void pass() {
        passed++;
    }

    void fail() {
        failed++;
        Thread.dumpStack();
    }

    static E[] elements = {null,null,null,null,null,null,null,null,null,null};

    static Object[] a = {1,163959085,5,1777716430,0,6,1,-1441244427,-469920255,7};

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
        new MyJVMTest_7900().equal(x, y);
    }
}
