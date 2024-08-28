public class MyJVMTest_9302 {

    static float[] a = { Float.NaN, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.MIN_VALUE, 0f, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, Float.MIN_VALUE, 0f };

    float[] test_2ci_oppos(float[] a, float[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123.f;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9302().test_2ci_oppos(a, b);
    }
}
