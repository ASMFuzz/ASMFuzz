public class MyJVMTest_11880 {

    static int actual = -1049110082;

    static int expected = -101090846;

    static String prop = "](Ne5}K;LE";

    int checkSize(int actual, int expected, String prop) {
        if (Math.abs(actual - expected) > 10) {
            System.err.println("Expected: " + expected);
            System.err.println("Actual: " + actual);
            throw new RuntimeException(prop + " is wrong");
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11880().checkSize(actual, expected, prop);
    }
}
