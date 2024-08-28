public class MyJVMTest_5937 {

    static float[] a = { 0.89492565f, 0f, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, 0.8090009f };

    static float[] b = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, 0.79705447f, Float.NEGATIVE_INFINITY };

    static int OFFSET = 3;

    float[] test_2ci_off(float[] a, float[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123.f;
            b[i + OFFSET] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5937().test_2ci_off(a, b);
    }
}
