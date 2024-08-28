public class MyJVMTest_14205 {

    static int value = -579411049;

    static int result = 4;

    static int expected = 0;

    int check(int value, int result, int expected) {
        if (result != expected)
            throw new InternalError(value + " failed: " + result + " != " + expected);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14205().check(value, result, expected);
    }
}
