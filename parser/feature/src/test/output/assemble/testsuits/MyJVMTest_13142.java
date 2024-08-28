public class MyJVMTest_13142 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0.83841807f, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, 0f, Float.MIN_VALUE, Float.NaN };

    static float[] b = { Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.5580151f, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY };

    static float c = Float.NaN;

    static float d = Float.MAX_VALUE;

    float[] test_2vi_neg(float[] a, float[] b, float c, float d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13142().test_2vi_neg(a, b, c, d);
    }
}
