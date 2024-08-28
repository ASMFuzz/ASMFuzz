public class MyJVMTest_13912 {

    static float[] a = { Float.MIN_VALUE, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0.94099444f, 0f, Float.MAX_VALUE, 0f };

    float[] test_2ci_neg(float[] a, float[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123.f;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13912().test_2ci_neg(a, b);
    }
}
