public class MyJVMTest_14108 {

    static long[] a = { 0, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 5683794859493934080L, 0, -9223372036854775808L, 0, 9223372036854775807L, 0 };

    static float[] b = { Float.MAX_VALUE, 0.94215846f, 0.4189294f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.44496888f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, 0f };

    static long c = 9223372036854775807L;

    static float d = Float.NEGATIVE_INFINITY;

    long[] test_vi_neg(long[] a, float[] b, long c, float d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14108().test_vi_neg(a, b, c, d);
    }
}
