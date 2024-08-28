public class MyJVMTest_15655 {

    static long[] a = { -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -2499027143316904247L, -9223372036854775808L, 0, 9223372036854775807L, 0 };

    static long[] b = { -9223372036854775808L, 9223372036854775807L, 7877997860010787545L, -7344444943147857164L, 9223372036854775807L, 9223372036854775807L, 0, -6100336872734743906L, 9223372036854775807L, 0 };

    static long c = 7531041844224757315L;

    static long d = 0;

    static int k = -1092276997;

    int test_2vi_inv(long[] a, long[] b, long c, long d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15655().test_2vi_inv(a, b, c, d, k);
    }
}
