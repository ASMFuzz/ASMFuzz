public class MyJVMTest_17590 {

    static String actual = ">H_e>,iH4:";

    static String expected = "=.95o9u2]2";

    String assertEquals(String actual, String expected) {
        if (!actual.equals(expected)) {
            throw new RuntimeException("Test failed: actual = '" + actual + "', expected = '" + expected + "'");
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17590().assertEquals(actual, expected);
    }
}
