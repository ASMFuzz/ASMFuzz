public class MyJVMTest_1453 {

    static int actual = 4;

    static int expected = 8;

    static String prop = "~K|9{eBWY=";

    int checkSize(int actual, int expected, String prop) {
        if (Math.abs(actual - expected) > 30) {
            System.err.println("Expected: " + expected);
            System.err.println("Actual: " + actual);
            throw new RuntimeException(prop + " is wrong");
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1453().checkSize(actual, expected, prop);
    }
}
