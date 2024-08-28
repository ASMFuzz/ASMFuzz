public class MyJVMTest_8005 {

    static long result = 9223372036854775807L;

    static long expected = -6598998056684696250L;

    long check(long result, long expected) {
        if (result != expected)
            throw new InternalError(result + " != " + expected);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8005().check(result, expected);
    }
}
