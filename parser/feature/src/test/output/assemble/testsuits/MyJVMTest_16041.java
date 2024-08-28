public class MyJVMTest_16041 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE };

    static double[] b = { Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, 0.8950186446284352, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN };

    float[] test_ci_oppos(float[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123.f;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16041().test_ci_oppos(a, b);
    }
}
