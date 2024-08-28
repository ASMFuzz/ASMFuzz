public class MyJVMTest_16120 {

    static long value = 0;

    static long result = 4310876218941181304L;

    static long expected = -9223372036854775808L;

    long check(long value, long result, long expected) {
        if (result != expected)
            throw new InternalError(value + " failed: " + result + " != " + expected);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16120().check(value, result, expected);
    }
}
