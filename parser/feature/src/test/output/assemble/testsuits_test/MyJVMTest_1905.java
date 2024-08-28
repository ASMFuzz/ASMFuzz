public class MyJVMTest_1905 {

    static long[] a = { 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0, 0, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L };

    static long[] b = { -1998277922416633944L, -9223372036854775808L, 0, -9223372036854775808L, 0, 9223372036854775807L, 0, 0, -9223372036854775808L, 0 };

    static float[] c = { Float.MAX_VALUE, 0.12910372f, Float.MAX_VALUE, 0f, Float.NEGATIVE_INFINITY, 0.5855119f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0f };

    static float[] d = { Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, 0.681609f, 0f, 0.2729228f, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE };

    long[] test_cp_oppos(long[] a, long[] b, float[] c, float[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1905().test_cp_oppos(a, b, c, d);
    }
}
