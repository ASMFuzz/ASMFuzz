public class MyJVMTest_5566 {

    static long[] a = { 0, 0, 7444931192723992678L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, 0, 0, 9223372036854775807L };

    static float[] b = { Float.NEGATIVE_INFINITY, Float.MIN_VALUE, Float.MIN_VALUE, Float.NaN, 0f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.NEGATIVE_INFINITY };

    static long c = -9223372036854775808L;

    static float d = 0f;

    long[] test_vi_oppos(long[] a, float[] b, long c, float d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5566().test_vi_oppos(a, b, c, d);
    }
}
