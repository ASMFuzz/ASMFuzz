public class MyJVMTest_1999 {

    static float[] a = { 0f, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, 0.6107726f, Float.MIN_VALUE, 0.4922734f };

    static double[] b = { Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0.1059857845023815, 0d, 0.7837782012916132, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0.7746610727799915, 0d, Double.POSITIVE_INFINITY };

    static float c = Float.POSITIVE_INFINITY;

    static double d = 0.2947044970166598;

    float[] test_vi_neg(float[] a, double[] b, float c, double d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1999().test_vi_neg(a, b, c, d);
    }
}
