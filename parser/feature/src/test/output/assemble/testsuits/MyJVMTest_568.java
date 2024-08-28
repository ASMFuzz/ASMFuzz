public class MyJVMTest_568 {

    static double[] a = { Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, 0d, 0d, 0.8511910370499447, Double.NaN, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY };

    static double[] b = { 0.1974278406956833, Double.NaN, 0.09518816533120156, 0.8367935369671273, 0.4707260393781282, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    double[] test_2ci_aln(double[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123.;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_568().test_2ci_aln(a, b);
    }
}
