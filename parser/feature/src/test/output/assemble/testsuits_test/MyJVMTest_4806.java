public class MyJVMTest_4806 {

    static int value = -159785840;

    static int result = -439201163;

    static int expected = 0;

    int check(int value, int result, int expected) {
        if (result != expected)
            throw new InternalError(value + " failed: " + result + " != " + expected);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4806().check(value, result, expected);
    }
}
