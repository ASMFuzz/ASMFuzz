public class MyJVMTest_17528 {

    static float[] a = { Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0.8791357f, Float.NaN, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE };

    static float[] b = { Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, 0.9804928f };

    static float c = Float.NaN;

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
        new MyJVMTest_17528().test_2vi_scl(a, b, c, d);
    }
}
