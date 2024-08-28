public class MyJVMTest_6292 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE };

    static float[] b = { Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE };

    static double[] c = { Double.NaN, 0d, Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, 0d };

    static double[] d = { 0.41231955610202253, 0d, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.MIN_VALUE, Double.MIN_VALUE, 0d, Double.MAX_VALUE, 0.44410074776122377 };

    static int ALIGN_OFF = 8;

    float[] test_cp_alnsrc(float[] a, float[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6292().test_cp_alnsrc(a, b, c, d);
    }
}
