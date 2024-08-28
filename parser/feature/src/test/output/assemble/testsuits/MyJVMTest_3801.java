public class MyJVMTest_3801 {

    static float[] a = { Float.NaN, 0.49386567f, Float.MIN_VALUE, 0.44568968f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0.31435698f, Float.NaN, 0f, 0.6897004f };

    static float[] b = { Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, 0.7790538f, 0f, 0.98746127f, Float.MIN_VALUE };

    static float c = Float.NEGATIVE_INFINITY;

    static float d = Float.MIN_VALUE;

    float[] test_2vi_neg(float[] a, float[] b, float c, float d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3801().test_2vi_neg(a, b, c, d);
    }
}
