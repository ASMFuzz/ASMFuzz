public class MyJVMTest_6182 {

    static long[] a = { 9223372036854775807L, 0, 0, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, -8311696383540173886L, -240019703746076013L, 9223372036854775807L };

    static long[] b = { 0, 9223372036854775807L, 4963249554009572857L, -8816609117006419278L, 0, 0, 0, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L };

    static long c = 9223372036854775807L;

    static long d = 0;

    static int k = 0;

    int test_2vi_inv(long[] a, long[] b, long c, long d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6182().test_2vi_inv(a, b, c, d, k);
    }
}
