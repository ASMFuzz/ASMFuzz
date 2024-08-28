public class MyJVMTest_17468 {

    static byte[] a = { -88, 39, 64, 71, -68, 98, -44, 7, 34, 118 };

    static byte[] b = { -30, -8, 17, 46, 27, 98, 104, -121, -13, -68 };

    static float[] c = { Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, 0f, Float.NaN, Float.POSITIVE_INFINITY, 0f, Float.NaN };

    static float[] d = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.NaN, Float.NaN, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.NaN };

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
        new MyJVMTest_17468().test_cp_unalndst(a, b, c, d);
    }
}
