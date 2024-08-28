public class MyJVMTest_5847 {

    static byte[] a = { -7, -104, -101, 113, 73, 106, -84, 127, 39, -118 };

    static float[] b = { Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, 0.79689f };

    static byte c = -128;

    static float d = Float.MIN_VALUE;

    byte[] test_vi(byte[] a, float[] b, byte c, float d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5847().test_vi(a, b, c, d);
    }
}
