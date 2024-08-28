public class MyJVMTest_12812 {

    static long[] a = { 0, -1451362507905327247L, 0, -7404887857529400222L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -6607025714244908682L, 0 };

    static long[] b = { 0, 9223372036854775807L, -9223372036854775808L, 0, 1510742621913966498L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 0, 777621207866715486L };

    static float[] c = { Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE };

    static float[] d = { Float.MAX_VALUE, Float.MIN_VALUE, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, 0.12709147f };

    long[] test_cp_neg(long[] a, long[] b, float[] c, float[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12812().test_cp_neg(a, b, c, d);
    }
}
