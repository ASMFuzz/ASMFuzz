public class MyJVMTest_12468 {

    static String actual = "x_6W@1dBu{";

    static String expected = "\"nV|8jx/cY";

    String checkPattern(String actual, String expected) {
        if (!expected.equals(actual)) {
            throw new RuntimeException("unexpected pattern:\n expected: " + expected + "\n   actual: " + actual);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12468().checkPattern(actual, expected);
    }
}
