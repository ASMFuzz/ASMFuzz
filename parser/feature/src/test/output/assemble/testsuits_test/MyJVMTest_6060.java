public class MyJVMTest_6060 {

    static float[] a = { Float.MIN_VALUE, 0.9023078f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, 0.2145384f, Float.NaN, Float.NEGATIVE_INFINITY, 0f };

    static double[] b = { Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.MIN_VALUE };

    static float c = 0.44848818f;

    static double d = 0d;

    float[] test_vi(float[] a, double[] b, float c, double d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6060().test_vi(a, b, c, d);
    }
}
