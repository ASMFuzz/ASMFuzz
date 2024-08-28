public class MyJVMTest_15002 {

    static long[] a = { 9149726165532538122L, 9223372036854775807L, -9223372036854775808L, -3491071383260091607L, 5179817309007682906L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L };

    static float[] b = { 0f, 0f, Float.MIN_VALUE, Float.POSITIVE_INFINITY, 0f, Float.NaN, 0.108018756f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN };

    static long c = 9223372036854775807L;

    static float d = Float.NEGATIVE_INFINITY;

    long[] test_vi_oppos(long[] a, float[] b, long c, float d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15002().test_vi_oppos(a, b, c, d);
    }
}
