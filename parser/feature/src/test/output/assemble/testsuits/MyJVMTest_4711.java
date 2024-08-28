public class MyJVMTest_4711 {

    static long[] a = { 0, 0, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, 1661583409959369152L, 0, 0, 9223372036854775807L };

    static float[] b = { Float.NaN, 0.5594079f, Float.NaN, 0f, Float.MIN_VALUE, 0.4726655f, Float.MAX_VALUE, Float.NaN, Float.MAX_VALUE, Float.MIN_VALUE };

    static long c = 9223372036854775807L;

    static float d = 0f;

    long[] test_vi_neg(long[] a, float[] b, long c, float d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4711().test_vi_neg(a, b, c, d);
    }
}
