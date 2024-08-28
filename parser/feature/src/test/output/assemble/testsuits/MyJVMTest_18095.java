public class MyJVMTest_18095 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 8607050168583665131L, 9223372036854775807L, -9223372036854775808L, 7370228282531774851L, 8360340471100975197L, 9223372036854775807L, 0 };

    static float[] b = { 0f, 0f, Float.NaN, Float.NaN, 0f, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, 0f };

    long[] test_ci_oppos(long[] a, float[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18095().test_ci_oppos(a, b);
    }
}
