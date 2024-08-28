public class MyJVMTest_13014 {

    static double[] a = { Double.POSITIVE_INFINITY, 0.10858606035373719, Double.NEGATIVE_INFINITY, 0.7043613758861662, Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    double[] test_ci_neg(double[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13014().test_ci_neg(a);
    }
}
