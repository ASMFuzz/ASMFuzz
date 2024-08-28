public class MyJVMTest_8497 {

    static long[] a = { -9223372036854775808L, -9223372036854775808L, 0, 0, -9057081245133574639L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L };

    static double[] b = { Double.NaN, 0d, Double.POSITIVE_INFINITY, Double.NaN, 0.9546642227231125, 0.6041598529341589, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN };

    long[] test_ci_neg(long[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8497().test_ci_neg(a, b);
    }
}
