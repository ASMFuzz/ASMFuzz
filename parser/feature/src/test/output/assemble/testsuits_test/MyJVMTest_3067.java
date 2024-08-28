public class MyJVMTest_3067 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 7178531850759230240L, -9223372036854775808L, 9223372036854775807L, -4520729921429520152L, 0 };

    static long[] b = { 0, -9223372036854775808L, -9223372036854775808L, -4724985239612196725L, 0, 3485503203424445705L, 0, 8780730285751102180L, 9223372036854775807L, 9223372036854775807L };

    static double[] c = { 0d, Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY };

    static double[] d = { Double.NaN, 0.2468192090110224, 0.037480113166085904, Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.NaN, Double.NaN, 0d, 0d };

    long[] test_cp_oppos(long[] a, long[] b, double[] c, double[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3067().test_cp_oppos(a, b, c, d);
    }
}
