public class MyJVMTest_9939 {

    static float[] a = { Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE };

    static double[] b = { Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE };

    float[] test_ci_neg(float[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123.f;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9939().test_ci_neg(a, b);
    }
}
