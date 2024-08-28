public class MyJVMTest_1139 {

    static float[] a = { 0f, Float.NaN, Float.MAX_VALUE, 0f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE };

    static float[] b = { 0f, Float.NaN, 0.12625521f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE };

    static float c = Float.MAX_VALUE;

    static float d = Float.MIN_VALUE;

    static int OFFSET = 3;

    float[] test_2vi_off(float[] a, float[] b, float c, float d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1139().test_2vi_off(a, b, c, d);
    }
}
