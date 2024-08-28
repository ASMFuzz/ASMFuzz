public class MyJVMTest_7906 {

    static byte[] a = { -13, 13, -35, -103, 75, -82, -122, 85, 105, -46 };

    static byte[] b = { -50, 30, 88, -67, -22, 94, 34, -7, 11, -28 };

    static float[] c = { Float.NaN, 0f, 0f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

    static float[] d = { 0.9752603f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0.40863597f, Float.MAX_VALUE, Float.MIN_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalndst(byte[] a, byte[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7906().test_cp_unalndst(a, b, c, d);
    }
}
