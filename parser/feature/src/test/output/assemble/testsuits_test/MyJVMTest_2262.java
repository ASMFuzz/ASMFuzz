public class MyJVMTest_2262 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, -6817770637511425158L, 3634436747028084483L, -1351778341224287037L, -8622196460199978755L, -9223372036854775808L, 0, 0, -9223372036854775808L };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.9332613293110813, 0d, 0d, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0.3658559075507264, 0d };

    static long c = 9223372036854775807L;

    static double d = Double.NEGATIVE_INFINITY;

    long[] test_vi_oppos(long[] a, double[] b, long c, double d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2262().test_vi_oppos(a, b, c, d);
    }
}
