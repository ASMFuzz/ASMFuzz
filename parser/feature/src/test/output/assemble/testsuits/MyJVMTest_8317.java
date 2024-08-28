public class MyJVMTest_8317 {

    static float[] a = { 0.959219f, 0.49841243f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, 0f };

    static float[] b = { Float.NaN, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, 0.4881968f, 0f, Float.POSITIVE_INFINITY, 0.97060776f };

    static int k = 6;

    int test_2ci_inv(float[] a, float[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123.f;
            b[i + k] = -103.f;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8317().test_2ci_inv(a, b, k);
    }
}
