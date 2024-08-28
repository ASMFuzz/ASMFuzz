public class MyJVMTest_6624 {

    static long value = -2377771842094007348L;

    static long result = -2213089813121116060L;

    static long expected = 9223372036854775807L;

    long check(long value, long result, long expected) {
        if (result != expected)
            throw new InternalError(value + " failed: " + result + " != " + expected);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6624().check(value, result, expected);
    }
}
