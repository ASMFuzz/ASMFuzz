public class MyJVMTest_4872 {

    static double[] a = { Double.NaN, Double.NaN, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.2679027280488875, 0.0526759229034135, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE };

    static double[] b = { Double.POSITIVE_INFINITY, 0.05964032256484819, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE };

    double[] test_2ci_oppos(double[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123.;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4872().test_2ci_oppos(a, b);
    }
}
