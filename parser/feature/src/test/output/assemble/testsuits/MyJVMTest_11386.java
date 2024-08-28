public class MyJVMTest_11386 {

    static double[] a = { Double.NaN, Double.NaN, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0.1968345209400315, Double.MIN_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY };

    static double[] b = { 0d, Double.NaN, Double.MAX_VALUE, 0d, Double.MIN_VALUE, Double.MIN_VALUE, 0d, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY };

    static int k = 0;

    int test_cp_inv(double[] a, double[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11386().test_cp_inv(a, b, k);
    }
}
