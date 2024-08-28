public class MyJVMTest_11899 {

    static String expected = "]H)k:pGwl$";

    static String actual = "krhlQ8?c%^";

    String test(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new IllegalStateException("Expected = " + expected + ", actual = " + actual);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11899().test(expected, actual);
    }
}
