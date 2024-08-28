public class MyJVMTest_6480 {

    static byte[] a = { 14, -12, 51, -22, -77, 125, 58, -48, 58, -125 };

    static float[] b = { Float.POSITIVE_INFINITY, Float.NaN, Float.NaN, Float.MIN_VALUE, 0f, Float.MAX_VALUE, Float.NaN, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY };

    static byte c = -128;

    static float d = Float.NEGATIVE_INFINITY;

    byte[] test_vi_neg(byte[] a, float[] b, byte c, float d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6480().test_vi_neg(a, b, c, d);
    }
}
