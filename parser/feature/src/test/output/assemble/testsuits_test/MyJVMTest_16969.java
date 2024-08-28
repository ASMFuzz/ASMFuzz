public class MyJVMTest_16969 {

    static long[] a = { -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, -1751358629886144345L, 147031219063176341L, 9223372036854775807L, -9223372036854775808L, 2591680526890280509L };

    static long[] b = { 9223372036854775807L, 0, -9223372036854775808L, 0, 9223372036854775807L, 0, 0, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L };

    static double[] c = { Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, 0d, Double.POSITIVE_INFINITY, 0d, Double.NaN, 0.8060467136389223, Double.MIN_VALUE };

    static double[] d = { Double.MAX_VALUE, Double.MIN_VALUE, 0.5405557213462494, Double.POSITIVE_INFINITY, Double.NaN, Double.MIN_VALUE, Double.MIN_VALUE, 0.12213063946760605, Double.MIN_VALUE, 0d };

    long[] test_cp_neg(long[] a, long[] b, double[] c, double[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16969().test_cp_neg(a, b, c, d);
    }
}
