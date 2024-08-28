public class MyJVMTest_6798 {

    static long[] a = { 0, -9223372036854775808L, 9223372036854775807L, 8072487922196246130L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 0, 0, -9223372036854775808L };

    static float[] b = { Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, 0.9962144f, 0f, Float.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    long[] test_ci_aln(long[] a, float[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6798().test_ci_aln(a, b);
    }
}
