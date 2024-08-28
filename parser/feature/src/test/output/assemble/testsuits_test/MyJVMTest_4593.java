public class MyJVMTest_4593 {

    static int expected = 0;

    static int actual = 3;

    int check(int expected, int actual) {
        if (actual != expected)
            throw new AssertionError(actual);
        return actual;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4593().check(expected, actual);
    }
}
