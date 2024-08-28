public class MyJVMTest_11810 {

    static int actual = 3;

    static int expected = 4;

    int assertEquals(int actual, int expected) {
        if (actual != expected) {
            throw new RuntimeException("Test failed: actual = '" + actual + "', expected = '" + expected + "'");
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11810().assertEquals(actual, expected);
    }
}
