public class MyJVMTest_12378 {

    static long[] a = { 619484133495370238L, 9223372036854775807L, 0, 0, 0, -9223372036854775808L, 0, 9223372036854775807L, 0, -4691516759061302356L };

    static long[] b = { -9223372036854775808L, 9223372036854775807L, 0, -7675915219549179675L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0, 9223372036854775807L, -3494551573932160614L };

    static double[] c = { Double.NaN, Double.MAX_VALUE, 0.7470373495656132, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, 0.49625116093972643, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static double[] d = { 0.15128958624665834, Double.NaN, 0d, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY, 0d };

    long[] test_cp_oppos(long[] a, long[] b, double[] c, double[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12378().test_cp_oppos(a, b, c, d);
    }
}
