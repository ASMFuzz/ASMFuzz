public class MyJVMTest_4197 {

    static float[] a = { Float.MIN_VALUE, Float.NaN, 0f, Float.NaN, Float.MAX_VALUE, Float.NaN, 0f, Float.NaN, Float.POSITIVE_INFINITY, Float.NaN };

    static float[] b = { Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.99094635f, Float.MIN_VALUE, Float.MIN_VALUE, 0.09424806f, Float.MAX_VALUE, Float.NaN };

    float[] test_2ci(float[] a, float[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123.f;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4197().test_2ci(a, b);
    }
}
