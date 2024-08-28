public class MyJVMTest_11776 {

    static double[] a = { Double.MIN_VALUE, 0.43884603655625876, Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0.6120645797411884, Double.NaN };

    static int k = 9;

    int test_ci_inv(double[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123.;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11776().test_ci_inv(a, k);
    }
}
