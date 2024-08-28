public class MyJVMTest_13983 {

    static int expected = 0;

    static int actual = 2062170781;

    int check(int expected, int actual) {
        if (actual != expected)
            throw new AssertionError(actual);
        return actual;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13983().check(expected, actual);
    }
}
