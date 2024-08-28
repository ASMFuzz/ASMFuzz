public class MyJVMTest_10629 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, 0, -6910501634056472119L, 0, 9223372036854775807L, 9223372036854775807L, 6597662830606918254L, 3070659146118074658L, -9223372036854775808L };

    static double[] b = { 0d, Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, 0.6648153646753784, Double.NEGATIVE_INFINITY, Double.NaN };

    long[] test_ci_oppos(long[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10629().test_ci_oppos(a, b);
    }
}
