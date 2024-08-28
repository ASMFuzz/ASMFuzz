public class MyJVMTest_8357 {

    static float[] a = { Float.POSITIVE_INFINITY, 0.68432015f, 0.096871614f, Float.MIN_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, 0.3565519f, Float.NaN, Float.POSITIVE_INFINITY, Float.MIN_VALUE };

    static float[] b = { 0.43807256f, Float.NEGATIVE_INFINITY, 0.15306008f, Float.MAX_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE };

    static float c = Float.NaN;

    static float d = 0f;

    float[] test_2vi(float[] a, float[] b, float c, float d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8357().test_2vi(a, b, c, d);
    }
}
