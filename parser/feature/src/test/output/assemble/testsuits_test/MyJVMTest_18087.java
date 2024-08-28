public class MyJVMTest_18087 {

    static long[] a = { -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 3711271170500902199L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L };

    static double[] b = { 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, 0.7930270136877636 };

    long[] test_ci_neg(long[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18087().test_ci_neg(a, b);
    }
}
