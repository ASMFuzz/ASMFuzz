public class MyJVMTest_12727 {

    static int expected = -397842;

    static int actual = 2;

    int assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new IllegalStateException("expected=" + expected + "; actual=" + actual);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12727().assertEquals(expected, actual);
    }
}
