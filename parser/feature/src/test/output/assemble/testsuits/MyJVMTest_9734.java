public class MyJVMTest_9734 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, 0.9744117639484993, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE };

    static double[] b = { Double.NaN, Double.NaN, 0d, Double.POSITIVE_INFINITY, Double.NaN, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0d, Double.NaN, Double.MIN_VALUE };

    static int ALIGN_OFF = 8;

    double[] test_2ci_aln(double[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123.;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9734().test_2ci_aln(a, b);
    }
}
