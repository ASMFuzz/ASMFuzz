public class MyJVMTest_3822 {

    static int i = 2;

    static int expected = -1217559046;

    static int result = 6;

    static long[] la = new long[] { 0x12345678abcdefL };

    int check(int i, int expected, int result) {
        if (result != expected) {
            throw new InternalError("Wrong population count for " + i + ": " + result + " != " + expected);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3822().check(i, expected, result);
    }
}
