public class MyJVMTest_1299 {

    static float[] a = { Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, 0f, Float.MIN_VALUE, Float.MIN_VALUE, 0f, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY };

    static float[] b = { Float.NaN, Float.MIN_VALUE, 0.83701134f, 0f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NaN, 0.9152496f, Float.POSITIVE_INFINITY };

    static double[] c = { Double.MAX_VALUE, 0.22872112354095064, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double[] d = { Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, 0d, 0.9106340896734976, Double.NEGATIVE_INFINITY, 0.5927022698586866, Double.MAX_VALUE };

    static int ALIGN_OFF = 8;

    float[] test_cp_alndst(float[] a, float[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1299().test_cp_alndst(a, b, c, d);
    }
}
