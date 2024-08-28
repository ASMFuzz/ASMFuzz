public class MyJVMTest_7376 {

    static float[] a = { Float.MIN_VALUE, Float.MIN_VALUE, 0.30777454f, Float.MAX_VALUE, 0.4304427f, 0f, 0.0138475895f, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE };

    static int k = -675383506;

    int test_ci_inv(float[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123.f;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7376().test_ci_inv(a, k);
    }
}
