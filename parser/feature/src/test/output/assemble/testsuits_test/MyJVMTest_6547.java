public class MyJVMTest_6547 {

    static float[] a = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0.551738f, Float.NaN, Float.POSITIVE_INFINITY, Float.NaN, 0f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

    static double[] b = { Double.NaN, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE };

    float[] test_ci_oppos(float[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123.f;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6547().test_ci_oppos(a, b);
    }
}
