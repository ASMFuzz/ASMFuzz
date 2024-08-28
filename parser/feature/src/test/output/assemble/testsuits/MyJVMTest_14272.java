public class MyJVMTest_14272 {

    static double[] a = { 0.1482537861020342, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY };

    static double[] b = { Double.NaN, 0.32817572538733464, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, 0.34454970997590595, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0d, Double.NaN };

    double[] test_2ci_oppos(double[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123.;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14272().test_2ci_oppos(a, b);
    }
}
