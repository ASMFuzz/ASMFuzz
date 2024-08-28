public class MyJVMTest_13560 {

    static float[] a = { Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f };

    static float[] b = { Float.MAX_VALUE, 0.003310144f, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY };

    float[] test_2ci(float[] a, float[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123.f;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13560().test_2ci(a, b);
    }
}
