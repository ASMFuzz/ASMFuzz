public class MyJVMTest_760 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0.42561084f, Float.NEGATIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static double[] b = { Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0.7819104518010622, 0.9245758916928966, 0d, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, 0d };

    float[] test_ci_neg(float[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123.f;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_760().test_ci_neg(a, b);
    }
}
