public class MyJVMTest_6465 {

    static T expected = null;

    static T actual = null;

    static String text = "#pZR8--i(D";

    <T> T assertEquals(T expected, T actual) {
        if (expected == null ? actual == null : expected.equals(actual))
            return;
        throw new AssertionError("expected: " + expected + ", actual: " + actual);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6465().assertEquals(expected, actual);
    }
}
