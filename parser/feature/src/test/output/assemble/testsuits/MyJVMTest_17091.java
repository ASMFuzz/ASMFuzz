public class MyJVMTest_17091 {

    static String s = "s_80<9aL|f";

    static String expected = "c<4\\FnCzD?";

    String assertEquals(String s, String expected) {
        if (!s.equals(expected)) {
            throw new RuntimeException("Expected: " + expected + " but found: " + s);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17091().assertEquals(s, expected);
    }
}
