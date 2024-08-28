public class MyJVMTest_16562 {

    static long[] a = { 9223372036854775807L, 0, 0, -5981506763538624756L, 0, -340306722068995377L, -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L };

    static float[] b = { Float.POSITIVE_INFINITY, 0.43754536f, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, 0f, Float.NaN, Float.POSITIVE_INFINITY };

    long[] test_ci_neg(long[] a, float[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16562().test_ci_neg(a, b);
    }
}
