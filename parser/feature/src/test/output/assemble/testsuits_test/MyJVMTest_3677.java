public class MyJVMTest_3677 {

    static double[] a = { Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.9757296033307872, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0d };

    double[] test_ci_neg(double[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3677().test_ci_neg(a);
    }
}
