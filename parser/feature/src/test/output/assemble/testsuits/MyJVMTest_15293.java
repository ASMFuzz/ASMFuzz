public class MyJVMTest_15293 {

    static byte[] a = { -5, 86, -110, 81, 43, -25, 47, 15, 115, -88 };

    static float[] b = { 0f, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE };

    static byte c = -94;

    static float d = 0.09189606f;

    byte[] test_vi(byte[] a, float[] b, byte c, float d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15293().test_vi(a, b, c, d);
    }
}
