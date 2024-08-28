public class MyJVMTest_2070 {

    static long[] a = { -9223372036854775808L, 8460768101943785306L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 8939827015197153163L, 9223372036854775807L, 9223372036854775807L, -2082795304563143301L };

    static double[] b = { Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, 0.4810930482478514, Double.NEGATIVE_INFINITY, 0d, Double.NaN, Double.NaN, Double.MAX_VALUE };

    static long c = 0;

    static double d = Double.MAX_VALUE;

    long[] test_vi_neg(long[] a, double[] b, long c, double d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2070().test_vi_neg(a, b, c, d);
    }
}
