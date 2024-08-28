public class MyJVMTest_6458 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L };

    static float[] b = { Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, 0.9049781f, Float.NaN, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_ci_unaln(long[] a, float[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6458().test_ci_unaln(a, b);
    }
}
