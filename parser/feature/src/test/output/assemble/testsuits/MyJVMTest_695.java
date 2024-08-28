public class MyJVMTest_695 {

    static float[] a = { 0.3291474f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, 0f, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.46493864f, Float.NaN, Float.NaN, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0f };

    float[] test_cp(float[] a, float[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_695().test_cp(a, b);
    }
}
