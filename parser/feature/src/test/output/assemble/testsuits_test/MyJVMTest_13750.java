public class MyJVMTest_13750 {

    static byte[] a = { -119, -121, -106, 40, -12, 99, -57, 103, 90, 115 };

    static float[] b = { Float.NaN, 0f, 0.36569655f, 0f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0f, Float.NaN, Float.MAX_VALUE };

    byte[] test_ci_neg(byte[] a, float[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13750().test_ci_neg(a, b);
    }
}
