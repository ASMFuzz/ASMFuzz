public class MyJVMTest_7410 {

    static int expected = 8;

    static int actual = 3;

    static int x = 42;

    int check(int expected, int actual) {
        if (expected != actual) {
            throw new RuntimeException("Wrong result, expected: " + expected + ", actual: " + actual);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7410().check(expected, actual);
    }
}
