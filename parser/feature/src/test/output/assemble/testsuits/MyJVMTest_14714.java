public class MyJVMTest_14714 {

    static Object val = 3;

    static Object expected = 1602224919;

    static F f = null;

    static StringBuffer sb = new StringBuffer();

    Object assertEquals(Object val, Object expected) {
        if (!val.equals(expected)) {
            throw new AssertionError("expected '" + expected + "' got '" + val + "'");
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14714().assertEquals(val, expected);
    }
}
