public class MyJVMTest_7549 {

    static String s = "2FG+\\;DdN~";

    static String expected = "VE[`)[HLK|";

    String assertEquals(String s, String expected) {
        if (!s.equals(expected)) {
            throw new RuntimeException("Expected: " + expected + " but found: " + s);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7549().assertEquals(s, expected);
    }
}
