public class MyJVMTest_11238 {

    static float[] a = { 0f, 0f, Float.NaN, Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, Float.NaN };

    static double[] b = { 0d, Double.NaN, 0.6282508120081384, 0.6855123434034648, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, 0.42956366181551464, Double.NEGATIVE_INFINITY };

    static float c = 0.46904355f;

    static double d = Double.MAX_VALUE;

    float[] test_vi_neg(float[] a, double[] b, float c, double d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11238().test_vi_neg(a, b, c, d);
    }
}
