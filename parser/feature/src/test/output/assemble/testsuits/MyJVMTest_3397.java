public class MyJVMTest_3397 {

    static int expected = 6;

    static int actual = 5;

    int assertEquals(int expected, int actual) {
        if (expected != actual) {
            throw new IllegalStateException("expected=" + expected + "; actual=" + actual);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3397().assertEquals(expected, actual);
    }
}
