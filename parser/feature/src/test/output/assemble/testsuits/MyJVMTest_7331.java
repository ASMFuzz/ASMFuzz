public class MyJVMTest_7331 {

    static float[] a = { Float.MIN_VALUE, Float.MIN_VALUE, 0.13535243f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, 0.10956091f, Float.NEGATIVE_INFINITY };

    static float[] b = { 0f, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

    float[] test_cp_neg(float[] a, float[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7331().test_cp_neg(a, b);
    }
}
