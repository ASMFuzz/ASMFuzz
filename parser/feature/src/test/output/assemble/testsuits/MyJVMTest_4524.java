public class MyJVMTest_4524 {

    static float[] a = { Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, 0f, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, 0.4158988f };

    float[] test_2ci_neg(float[] a, float[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123.f;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4524().test_2ci_neg(a, b);
    }
}
