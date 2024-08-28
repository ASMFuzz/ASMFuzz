public class MyJVMTest_16300 {

    static long[] a = { 9223372036854775807L, 0, 5372302966086149764L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -6128360763332036064L, 0, 9223372036854775807L };

    static float[] b = { Float.POSITIVE_INFINITY, 0.5679576f, Float.MAX_VALUE, Float.MIN_VALUE, 0f, Float.NaN, 0f, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    long[] test_ci_aln(long[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16300().test_ci_aln(a, b);
    }
}
