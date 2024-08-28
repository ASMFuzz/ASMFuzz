public class MyJVMTest_6066 {

    static long[] a = { -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -6335423757484790506L, 3934949433909163055L, 9027543082049256730L, -9223372036854775808L, 9223372036854775807L, 0, 0 };

    static double[] b = { Double.MIN_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, 0.763364932409133 };

    static int ALIGN_OFF = 8;

    long[] test_ci_aln(long[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6066().test_ci_aln(a, b);
    }
}
