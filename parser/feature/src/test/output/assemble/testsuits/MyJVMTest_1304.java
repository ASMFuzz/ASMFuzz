public class MyJVMTest_1304 {

    static float[] a = { Float.MIN_VALUE, Float.NaN, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, 0.7181859f, Float.MAX_VALUE, 0.12383276f };

    static double[] b = { Double.NaN, Double.MIN_VALUE, 0d, Double.NaN, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, 0.6816816256408693, Double.MAX_VALUE };

    float[] test_ci(float[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123.f;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1304().test_ci(a, b);
    }
}
