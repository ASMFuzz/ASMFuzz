public class MyJVMTest_1519 {

    static float[] a = { Float.NaN, 0f, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, 0.29591888f, Float.MAX_VALUE, 0f, Float.MAX_VALUE, 0f };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, 0.3733577407309293, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    float[] test_ci_aln(float[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123.f;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1519().test_ci_aln(a, b);
    }
}
