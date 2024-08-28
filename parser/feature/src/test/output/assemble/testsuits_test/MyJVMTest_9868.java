public class MyJVMTest_9868 {

    static float[] a = { Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, Float.NaN, 0f, 0.04073769f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

    static float[] b = { Float.MIN_VALUE, 0.7572023f, 0f, Float.NaN, 0.8386783f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

    float[] test_cp(float[] a, float[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9868().test_cp(a, b);
    }
}
