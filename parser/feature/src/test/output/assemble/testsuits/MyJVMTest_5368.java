public class MyJVMTest_5368 {

    static float[] a = { 0f, 0.6859605f, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, Float.MAX_VALUE };

    static float[] b = { Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, 0.84640414f, Float.NaN, 0f, Float.MAX_VALUE, 0f, Float.NaN };

    static float c = 0.5407471f;

    static float d = Float.MAX_VALUE;

    static int k = 0;

    int test_2vi_inv(float[] a, float[] b, float c, float d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5368().test_2vi_inv(a, b, c, d, k);
    }
}
