public class MyJVMTest_12746 {

    static Object x = 8;

    static Object y = 332383271;

    static int tests = -2028454791;

    Object assertEquals(Object x, Object y) {
        if (!x.equals(y)) {
            throw new RuntimeException("assertEquals: " + x + " != " + y);
        }
        ++tests;
        return y;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12746().assertEquals(x, y);
    }
}
