public class MyJVMTest_12259 {

    static float[] a = { Float.NaN, 0f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, Float.NaN, 0.97920823f };

    static double[] b = { Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN };

    static float c = Float.MIN_VALUE;

    static double d = Double.MAX_VALUE;

    static int ALIGN_OFF = 8;

    float[] test_vi_aln(float[] a, double[] b, float c, double d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12259().test_vi_aln(a, b, c, d);
    }
}
