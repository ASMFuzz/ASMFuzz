public class MyJVMTest_13164 {

    static int i = 1536293152;

    static int expected = 2;

    static int result = 8;

    static long[] la = new long[] { 0x12345678abcdefL };

    int check(int i, int expected, int result) {
        if (result != expected) {
            throw new InternalError("Wrong population count for " + i + ": " + result + " != " + expected);
        }
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13164().check(i, expected, result);
    }
}
