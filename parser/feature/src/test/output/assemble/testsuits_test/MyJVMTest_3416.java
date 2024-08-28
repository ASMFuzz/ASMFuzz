public class MyJVMTest_3416 {

    static Object x = 0;

    static Object y = 1866101711;

    static int tests = 0;

    Object assertEquals(Object x, Object y) {
        if (!x.equals(y)) {
            throw new RuntimeException("assertEquals: " + x + " != " + y);
        }
        ++tests;
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3416().assertEquals(x, y);
    }
}
