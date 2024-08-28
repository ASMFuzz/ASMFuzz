public class MyJVMTest_8528 {

    static long l = 0;

    static int expected = 808204181;

    static int result = 6;

    static long[] la = new long[] { 0x12345678abcdefL };

    int check(long l, int expected, int result) {
        if (result != expected) {
            throw new InternalError("Wrong population count for " + l + ": " + result + " != " + expected);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8528().check(l, expected, result);
    }
}
