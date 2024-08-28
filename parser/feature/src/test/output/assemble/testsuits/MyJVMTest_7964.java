public class MyJVMTest_7964 {

    static float[] a = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0f, 0.5675794f, Float.NaN, Float.MIN_VALUE };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.NaN, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY };

    static float c = Float.MAX_VALUE;

    static float d = Float.MAX_VALUE;

    static int SCALE = 2;

    float[] test_2vi_scl(float[] a, float[] b, float c, float d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7964().test_2vi_scl(a, b, c, d);
    }
}
