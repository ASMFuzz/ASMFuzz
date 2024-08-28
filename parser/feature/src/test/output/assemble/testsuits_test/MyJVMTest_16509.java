public class MyJVMTest_16509 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -4055922951201042983L, 9223372036854775807L, 0, -417474365050536412L, 0, 9223372036854775807L, 1707590416849297972L };

    static long[] b = { 0, -9223372036854775808L, -9223372036854775808L, 0, 0, -9223372036854775808L, -9223372036854775808L, 780296998026725188L, -9223372036854775808L, 0 };

    static double[] c = { Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, 0.6778689948971748, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN };

    static double[] d = { 0.7400665788489452, Double.POSITIVE_INFINITY, 0d, Double.MAX_VALUE, 0.10427350819252246, Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.NaN };

    long[] test_cp(long[] a, long[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16509().test_cp(a, b, c, d);
    }
}
