public class MyJVMTest_7109 {

    static long[] a = { 9223372036854775807L, 0, 57986586338967856L, -9223372036854775808L, 655260278575985943L, -9223372036854775808L, 0, 0, -9223372036854775808L, 9223372036854775807L };

    static long[] b = { 9223372036854775807L, 9223372036854775807L, 5229372760445909284L, -9223372036854775808L, 0, 9223372036854775807L, -377319671491528956L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L };

    static float[] c = { Float.NaN, 0.054649413f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.MAX_VALUE, Float.MAX_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.NaN };

    static float[] d = { Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, 0f, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, 0f };

    static int ALIGN_OFF = 8;

    long[] test_cp_alndst(long[] a, long[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7109().test_cp_alndst(a, b, c, d);
    }
}
