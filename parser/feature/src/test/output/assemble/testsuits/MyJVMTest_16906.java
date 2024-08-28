public class MyJVMTest_16906 {

    static float[] a = { 0.7886317f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.47439694f, Float.MIN_VALUE, 0.85752064f, Float.NEGATIVE_INFINITY };

    static int k = 7;

    int test_ci_inv(float[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123.f;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16906().test_ci_inv(a, k);
    }
}
