public class MyJVMTest_8238 {

    static long[] a = { -3504002538731226275L, -7728048352778907414L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0, 0, -9223372036854775808L, 9223372036854775807L };

    static long[] b = { 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L };

    static float[] c = { Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY };

    static float[] d = { Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_cp_unalnsrc(long[] a, long[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8238().test_cp_unalnsrc(a, b, c, d);
    }
}
