public class MyJVMTest_5005 {

    static short[] a = { -32768, 32767, 14263, -32768, -32768, -32768, 7427, 32767, 28670, -14850 };

    static short[] b = { -32768, 32767, 0, -32768, 32767, 32767, 0, 21780, -32768, 0 };

    static float[] c = { 0.8489256f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, 0.35806245f };

    static float[] d = { Float.NEGATIVE_INFINITY, 0f, Float.NaN, Float.MAX_VALUE, 0.6322726f, Float.MAX_VALUE, 0.39917183f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalndst(short[] a, short[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5005().test_cp_unalndst(a, b, c, d);
    }
}
