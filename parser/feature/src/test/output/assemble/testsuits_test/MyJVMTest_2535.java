public class MyJVMTest_2535 {

    static int actual = 4;

    static int expected = -1522638329;

    int assertEquals(int actual, int expected) {
        if (actual != expected) {
            throw new RuntimeException("Test failed: actual = '" + actual + "', expected = '" + expected + "'");
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2535().assertEquals(actual, expected);
    }
}
