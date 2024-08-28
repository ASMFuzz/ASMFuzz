public class MyJVMTest_12520 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN };

    float[] test_ci_neg(float[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12520().test_ci_neg(a);
    }
}
