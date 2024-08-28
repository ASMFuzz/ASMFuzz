public class MyJVMTest_11518 {

    static long[] a = { 2383661214207193558L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L };

    static double[] b = { Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, 0d, 0.938271104398945, Double.MAX_VALUE, 0.6119575357183709, Double.NaN, Double.NEGATIVE_INFINITY };

    static long c = 9223372036854775807L;

    static double d = Double.NaN;

    long[] test_vi_oppos(long[] a, double[] b, long c, double d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11518().test_vi_oppos(a, b, c, d);
    }
}
