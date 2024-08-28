public class MyJVMTest_2618 {

    static String expected = "illL)#HStW";

    static String actual = "YC1((\"s]Dl";

    String test(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new IllegalStateException("Expected = " + expected + ", actual = " + actual);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2618().test(expected, actual);
    }
}
