public class MyJVMTest_5800 {

    static long[] a = { -9223372036854775808L, 0, -7447050463380938397L, -9223372036854775808L, -9223372036854775808L, -7431094380660921606L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 3754974834257626455L };

    static long[] b = { -9223372036854775808L, -1080331814774293484L, 0, 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L, -1078447745030383277L, 9223372036854775807L, -7578553854941873067L };

    static long c = 0;

    static long d = -9223372036854775808L;

    int test_2vi_oppos(long[] a, long[] b, long c, long d) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5800().test_2vi_oppos(a, b, c, d);
    }
}
