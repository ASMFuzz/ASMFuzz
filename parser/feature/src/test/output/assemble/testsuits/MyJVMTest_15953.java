public class MyJVMTest_15953 {

    static T expected = null;

    static T actual = null;

    static String text = "^73`O7]JRd";

    <T> T assertEquals(T expected, T actual) {
        if (expected == null ? actual == null : expected.equals(actual))
            return;
        throw new AssertionError("expected: " + expected + ", actual: " + actual);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15953().assertEquals(expected, actual);
    }
}
