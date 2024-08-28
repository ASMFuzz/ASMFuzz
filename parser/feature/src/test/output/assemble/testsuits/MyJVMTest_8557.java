public class MyJVMTest_8557 {

    static long[] a = { 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0, 0, 0, -9223372036854775808L, 0 };

    static long[] b = { 7521531436640973979L, -9223372036854775808L, 0, 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L, 0, 0, 9223372036854775807L };

    static float[] c = { Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.37755483f, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.NaN, 0f, Float.MIN_VALUE };

    static float[] d = { Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0.908702f, Float.NaN, 0.049710512f, Float.NaN, Float.NaN, Float.NaN, Float.MIN_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_cp_unalndst(long[] a, long[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8557().test_cp_unalndst(a, b, c, d);
    }
}
