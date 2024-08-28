public class MyJVMTest_17572 {

    static long result = 1587210778389078765L;

    static long expected = -8610238826390609388L;

    long check(long result, long expected) {
        if (result != expected)
            throw new InternalError(result + " != " + expected);
        return expected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17572().check(result, expected);
    }
}
