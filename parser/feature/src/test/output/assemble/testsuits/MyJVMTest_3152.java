public class MyJVMTest_3152 {

    static String actual = "k~B'~.'ps ";

    static String expected = "J@X\"Y\"+~&F";

    String checkPattern(String actual, String expected) {
        if (!expected.equals(actual)) {
            throw new RuntimeException("unexpected pattern:\n expected: " + expected + "\n   actual: " + actual);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3152().checkPattern(actual, expected);
    }
}
