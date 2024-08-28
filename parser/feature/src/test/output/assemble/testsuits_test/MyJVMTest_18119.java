public class MyJVMTest_18119 {

    static long l = 0;

    static int expected = 0;

    static int result = 0;

    static long[] la = new long[] { 0x12345678abcdefL };

    int check(long l, int expected, int result) {
        if (result != expected) {
            throw new InternalError("Wrong population count for " + l + ": " + result + " != " + expected);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18119().check(l, expected, result);
    }
}
