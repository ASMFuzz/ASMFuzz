public class MyJVMTest_2505 {

    static double[] a = { Double.NaN, Double.MAX_VALUE, 0.4976410473553995, 0.17889766924964545, 0.25750501426987027, Double.NEGATIVE_INFINITY, 0d, 0d, Double.NaN, Double.MIN_VALUE };

    static int k = 0;

    int test_ci_inv(double[] a, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123.;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2505().test_ci_inv(a, k);
    }
}
