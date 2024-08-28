public class MyJVMTest_17151 {

    static long[] a = { -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, -3538700439993236726L, -6522537362124711421L, -9223372036854775808L, 0, -9223372036854775808L, 0 };

    static float[] b = { Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY };

    long[] test_ci(long[] a, float[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17151().test_ci(a, b);
    }
}
