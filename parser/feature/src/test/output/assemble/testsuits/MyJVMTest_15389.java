public class MyJVMTest_15389 {

    static float[] a = { 0.6562775f, 0f, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, 0.5366084f, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static float[] b = { Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, 0f, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static int OFFSET = 3;

    float[] test_2ci_off(float[] a, float[] b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123.f;
            b[i + OFFSET] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15389().test_2ci_off(a, b);
    }
}
