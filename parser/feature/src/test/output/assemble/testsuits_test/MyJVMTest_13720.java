public class MyJVMTest_13720 {

    static long[] a = { -3645804964782043334L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 3206502165513602626L, 9223372036854775807L, 0, -9223372036854775808L };

    static long[] b = { -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 1550047776723779526L, 0, -7302120839863792236L, 9223372036854775807L, 0 };

    long[] test_2ci_oppos(long[] a, long[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13720().test_2ci_oppos(a, b);
    }
}
