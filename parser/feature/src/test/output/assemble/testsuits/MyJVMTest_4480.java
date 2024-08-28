public class MyJVMTest_4480 {

    static long[] a = { -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L, -555079481620905579L, -5615432056339040777L, -9223372036854775808L, -7822199410264375107L, -1831625715799787377L, 9223372036854775807L };

    static float[] b = { Float.NaN, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0.34572756f, Float.POSITIVE_INFINITY, 0.68132275f, Float.NEGATIVE_INFINITY, 0f, 0.97652507f };

    static long c = 0;

    static float d = Float.MIN_VALUE;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_vi_unaln(long[] a, float[] b, long c, float d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4480().test_vi_unaln(a, b, c, d);
    }
}
