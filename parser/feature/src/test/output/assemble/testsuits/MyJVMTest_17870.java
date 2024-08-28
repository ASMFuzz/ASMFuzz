public class MyJVMTest_17870 {

    static double[] a = { Double.MAX_VALUE, 0.4226923651453438, Double.MAX_VALUE, Double.MIN_VALUE, 0.6450052632492044, 0d, 0d, 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY };

    static double[] b = { Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY };

    static int k = 5;

    int test_2ci_inv(double[] a, double[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123.;
            b[i + k] = -103.;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17870().test_2ci_inv(a, b, k);
    }
}
