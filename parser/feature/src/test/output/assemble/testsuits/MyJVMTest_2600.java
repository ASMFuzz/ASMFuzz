public class MyJVMTest_2600 {

    static int actual = 0;

    static int expected = -1987324835;

    static String prop = "jH~4868em=";

    int checkSize(int actual, int expected, String prop) {
        if (Math.abs(actual - expected) > 10) {
            System.err.println("Expected: " + expected);
            System.err.println("Actual: " + actual);
            throw new RuntimeException(prop + " is wrong");
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2600().checkSize(actual, expected, prop);
    }
}
