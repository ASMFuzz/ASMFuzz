public class MyJVMTest_7045 {

    static long[] a = { -9223372036854775808L, 2860551346123521143L, -9223372036854775808L, 0, -9223372036854775808L, -6265607243341966257L, -9223372036854775808L, 9223372036854775807L, 0, 8856453383978767667L };

    static float[] b = { 0f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, 0.77840245f, 0f, Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f };

    long[] test_ci_neg(long[] a, float[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7045().test_ci_neg(a, b);
    }
}
