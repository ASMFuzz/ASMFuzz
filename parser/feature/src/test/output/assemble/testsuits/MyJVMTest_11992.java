public class MyJVMTest_11992 {

    static byte[] a = { 57, -61, -32, -24, 4, -51, 59, 55, 79, -128 };

    static byte[] b = { -70, -76, 90, 21, -102, -71, -88, -58, -111, 101 };

    static float[] c = { Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, 0f, 0.9192327f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, 0f };

    static float[] d = { 0f, Float.POSITIVE_INFINITY, Float.NaN, 0.38582605f, 0f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.3576228f, Float.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalnsrc(byte[] a, byte[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11992().test_cp_unalnsrc(a, b, c, d);
    }
}
