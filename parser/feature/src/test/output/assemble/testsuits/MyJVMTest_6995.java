public class MyJVMTest_6995 {

    static long[] a = { -1336980495815089868L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L };

    static long[] b = { -9223372036854775808L, -7759089298157253963L, 0, -9223372036854775808L, -9223372036854775808L, 2041678071730665338L, -9223372036854775808L, 0, -9223372036854775808L, 0 };

    static double[] c = { Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.NaN, Double.MIN_VALUE, 0.2974899470526283, 0.6538565603728367, Double.NaN, Double.NaN, 0d };

    static double[] d = { Double.NaN, 0d, 0d, Double.MAX_VALUE, Double.MAX_VALUE, 0.5004153456789748, 0d, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE };

    long[] test_cp(long[] a, long[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6995().test_cp(a, b, c, d);
    }
}
