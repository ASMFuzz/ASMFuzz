public class MyJVMTest_412 {

    static double[] a = { Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0.7926258261305548, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE };

    static double[] b = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.NaN, Double.NaN };

    double[] test_2ci(double[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123.;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_412().test_2ci(a, b);
    }
}
