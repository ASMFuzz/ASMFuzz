public class MyJVMTest_5291 {

    static Object val = 8;

    static Object expected = 9;

    static F f = null;

    static StringBuffer sb = new StringBuffer();

    Object assertEquals(Object val, Object expected) {
        if (!val.equals(expected)) {
            throw new AssertionError("expected '" + expected + "' got '" + val + "'");
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5291().assertEquals(val, expected);
    }
}
