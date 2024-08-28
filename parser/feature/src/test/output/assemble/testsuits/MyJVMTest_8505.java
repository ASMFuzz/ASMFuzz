public class MyJVMTest_8505 {

    static long[] a = { -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, 0, 6692141484059194368L, -9223372036854775808L, -4228816815255312651L };

    static float[] b = { Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0.21769309f, Float.NaN, Float.NaN, Float.MAX_VALUE, Float.MIN_VALUE, 0f, 0.8511515f, Float.NEGATIVE_INFINITY };

    long[] test_ci_oppos(long[] a, float[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8505().test_ci_oppos(a, b);
    }
}
