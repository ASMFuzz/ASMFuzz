public class MyJVMTest_11316 {

    static long[] a = { 0, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0, 8458830403930297002L, 0, 0, -9223372036854775808L };

    static double[] b = { 0.6030644077509052, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.6831928503760566, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, 0.4640045724759163, Double.NaN, Double.MIN_VALUE };

    static long c = 2901452735357424988L;

    static double d = Double.MIN_VALUE;

    long[] test_vi_neg(long[] a, double[] b, long c, double d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11316().test_vi_neg(a, b, c, d);
    }
}
