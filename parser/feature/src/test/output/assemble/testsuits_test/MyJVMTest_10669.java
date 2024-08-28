public class MyJVMTest_10669 {

    static int actual = 0;

    static int expected = -251479124;

    static String prop = "?4BGvXt{*\"";

    int checkSize(int actual, int expected, String prop) {
        if (Math.abs(actual - expected) > 30) {
            System.err.println("Expected: " + expected);
            System.err.println("Actual: " + actual);
            throw new RuntimeException(prop + " is wrong");
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10669().checkSize(actual, expected, prop);
    }
}
