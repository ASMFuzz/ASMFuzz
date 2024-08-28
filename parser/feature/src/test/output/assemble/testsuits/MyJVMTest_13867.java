public class MyJVMTest_13867 {

    static long[] a = { 9223372036854775807L, -4313455011514305328L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, -2518531984996564353L, -9223372036854775808L, -9223372036854775808L, -8660426158707701105L };

    static float[] b = { 0.28686464f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, 0.025402963f, 0f, 0f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE };

    static long c = 9223372036854775807L;

    static float d = Float.MAX_VALUE;

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
        new MyJVMTest_13867().test_vi_unaln(a, b, c, d);
    }
}
