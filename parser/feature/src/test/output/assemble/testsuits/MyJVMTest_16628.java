public class MyJVMTest_16628 {

    static long[] a = { -9223372036854775808L, 0, 9223372036854775807L, 0, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, 1564469493381803909L, 6307500455077585459L };

    static long[] b = { 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -8831629144189597572L, 0, -9223372036854775808L, 9223372036854775807L, 8012263766515909343L, 9223372036854775807L };

    static float[] c = { Float.POSITIVE_INFINITY, Float.NaN, 0.8968497f, Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, Float.POSITIVE_INFINITY, Float.NaN, Float.MIN_VALUE, Float.NEGATIVE_INFINITY };

    static float[] d = { Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE, 0.9387041f };

    static int ALIGN_OFF = 8;

    long[] test_cp_alndst(long[] a, long[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16628().test_cp_alndst(a, b, c, d);
    }
}
