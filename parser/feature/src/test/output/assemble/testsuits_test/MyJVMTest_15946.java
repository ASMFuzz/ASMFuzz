public class MyJVMTest_15946 {

    static long[] a = { 9223372036854775807L, 4435164525056172269L, 7181991864795471939L, 9223372036854775807L, -9223372036854775808L, 0, 0, 0, 0, 9223372036854775807L };

    static float[] b = { 0f, 0f, 0.54314274f, Float.NEGATIVE_INFINITY, 0.6705146f, 0f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.POSITIVE_INFINITY };

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
        new MyJVMTest_15946().test_ci_unaln(a, b);
    }
}
