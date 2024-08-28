public class MyJVMTest_9168 {

    static long[] a = { -2089696127916038013L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, 1920180662037111530L, 0, 9223372036854775807L, 0, -9223372036854775808L };

    static long[] b = { -963644863236579734L, 3673812058572982080L, 0, -9223372036854775808L, -3116796390261097870L, 0, 9223372036854775807L, -989191649984808608L, 9223372036854775807L, 0 };

    static float[] c = { Float.NEGATIVE_INFINITY, 0.45498395f, Float.NEGATIVE_INFINITY, 0f, Float.NaN, Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, 0f, Float.MAX_VALUE };

    static float[] d = { Float.NaN, 0f, Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.NaN, Float.MIN_VALUE, 0.63090074f, 0.32985646f, Float.POSITIVE_INFINITY };

    long[] test_cp(long[] a, long[] b, float[] c, float[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9168().test_cp(a, b, c, d);
    }
}
