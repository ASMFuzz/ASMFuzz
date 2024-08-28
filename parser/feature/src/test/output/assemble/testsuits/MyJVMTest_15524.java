public class MyJVMTest_15524 {

    static long[] a = { 6838462056006941731L, 0, 0, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 2723111693743302612L, -9223372036854775808L, -9223372036854775808L };

    static double[] b = { 0d, Double.MIN_VALUE, 0d, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d, Double.MAX_VALUE };

    static int ALIGN_OFF = 8;

    long[] test_ci_aln(long[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15524().test_ci_aln(a, b);
    }
}
