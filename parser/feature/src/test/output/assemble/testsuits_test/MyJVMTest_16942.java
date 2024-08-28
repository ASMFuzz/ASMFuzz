public class MyJVMTest_16942 {

    static int expected = 2;

    static int actual = 6;

    static int x = 42;

    int check(int expected, int actual) {
        if (expected != actual) {
            throw new RuntimeException("Wrong result, expected: " + expected + ", actual: " + actual);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16942().check(expected, actual);
    }
}
