public class MyJVMTest_17895 {

    static float[] a = { Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.018718004f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.698855f, Float.NaN, Float.MIN_VALUE };

    static float[] b = { 0.6149414f, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, 0f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE };

    static int k = 0;

    int test_2ci_inv(float[] a, float[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123.f;
            b[i + k] = -103.f;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17895().test_2ci_inv(a, b, k);
    }
}
