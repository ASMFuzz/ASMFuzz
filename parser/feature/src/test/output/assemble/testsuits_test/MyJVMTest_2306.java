public class MyJVMTest_2306 {

    static byte[] a = { -1, -70, 21, -35, 53, 50, -82, -10, 39, 66 };

    static byte[] b = { -91, 63, 34, -31, -87, 26, 107, -23, -49, 77 };

    static float[] c = { Float.NaN, Float.NaN, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, 0.63869107f, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY };

    static float[] d = { 0f, Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alndst(byte[] a, byte[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2306().test_cp_alndst(a, b, c, d);
    }
}
