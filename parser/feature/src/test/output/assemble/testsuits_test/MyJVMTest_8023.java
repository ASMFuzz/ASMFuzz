public class MyJVMTest_8023 {

    static String actual = "Iu$.FHNpOh";

    static String expected = "OaCPhp6ZUo";

    String assertEquals(String actual, String expected) {
        if (!actual.equals(expected)) {
            throw new RuntimeException("Test failed: actual = '" + actual + "', expected = '" + expected + "'");
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8023().assertEquals(actual, expected);
    }
}
