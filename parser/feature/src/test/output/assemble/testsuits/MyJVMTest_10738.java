public class MyJVMTest_10738 {

    static float[] a = { Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, 0.49510372f, 0.4480313f, Float.NaN, Float.NEGATIVE_INFINITY, 0f, Float.NaN, Float.MAX_VALUE };

    static double[] b = { Double.MAX_VALUE, Double.NaN, 0.8613695224488598, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.4902027265024057, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN };

    static int ALIGN_OFF = 8;

    float[] test_ci_aln(float[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123.f;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10738().test_ci_aln(a, b);
    }
}
