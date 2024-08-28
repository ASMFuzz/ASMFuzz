public class MyJVMTest_10503 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.06765211f, 0f, Float.NaN, Float.NaN, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN };

    static float[] b = { 0.24936819f, Float.NEGATIVE_INFINITY, 0f, 0f, Float.MAX_VALUE, 0.73825556f, Float.POSITIVE_INFINITY, 0f, 0f, Float.NaN };

    static double[] c = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, 0.76127565956873, Double.NaN, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double[] d = { Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, 0d, 0d, Double.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    float[] test_cp_alndst(float[] a, float[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10503().test_cp_alndst(a, b, c, d);
    }
}
