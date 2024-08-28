public class MyJVMTest_14879 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, 0.14088583f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, 0f, Float.MIN_VALUE, 0.5878216f };

    static float[] b = { Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, 0f, Float.NaN, Float.NEGATIVE_INFINITY, 0.46186423f };

    static double[] c = { Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, 0d, Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static double[] d = { Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, 0.05292138594234186, 0d, 0.41889768913694103, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0d };

    float[] test_cp(float[] a, float[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14879().test_cp(a, b, c, d);
    }
}
