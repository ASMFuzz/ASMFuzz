public class MyJVMTest_3153 {

    static long[] a = { 1137227963019937745L, -9223372036854775808L, 9223372036854775807L, 0, -8113654506236789214L, 0, 9223372036854775807L, 0, 4781908264533137135L, -9223372036854775808L };

    static float[] b = { Float.POSITIVE_INFINITY, 0.08388257f, Float.NaN, Float.MAX_VALUE, Float.NaN, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.7360212f, Float.NaN, Float.POSITIVE_INFINITY };

    static long c = -9223372036854775808L;

    static float d = 0.036269844f;

    static int ALIGN_OFF = 8;

    long[] test_vi_aln(long[] a, float[] b, long c, float d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3153().test_vi_aln(a, b, c, d);
    }
}
