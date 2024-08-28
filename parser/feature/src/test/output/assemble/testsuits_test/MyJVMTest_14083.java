public class MyJVMTest_14083 {

    static float[] a = { Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.9733321f, 0f, Float.MIN_VALUE };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY };

    static int SCALE = 2;

    float[] test_2ci_scl(float[] a, float[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123.f;
            b[i * SCALE] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14083().test_2ci_scl(a, b);
    }
}
