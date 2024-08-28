public class MyJVMTest_14793 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.MAX_VALUE };

    static float[] b = { Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.919325f, Float.MIN_VALUE, 0.23544258f, Float.POSITIVE_INFINITY, 0.03889066f, Float.MIN_VALUE, 0.9168192f, Float.MIN_VALUE };

    static float c = Float.POSITIVE_INFINITY;

    static float d = Float.NEGATIVE_INFINITY;

    static int k = 4;

    int test_2vi_inv(float[] a, float[] b, float c, float d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14793().test_2vi_inv(a, b, c, d, k);
    }
}
