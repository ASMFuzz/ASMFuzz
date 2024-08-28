public class MyJVMTest_4375 {

    static byte[] a = { 25, -101, 17, 105, 54, -54, 62, -121, -3, 13 };

    static float[] b = { Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE, 0.23027205f, Float.NaN, Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY };

    byte[] test_ci_neg(byte[] a, float[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4375().test_ci_neg(a, b);
    }
}
