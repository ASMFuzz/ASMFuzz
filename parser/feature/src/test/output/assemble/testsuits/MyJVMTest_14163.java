public class MyJVMTest_14163 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, 0d, 0.4599160009945017, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE };

    static double[] b = { Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, 0d, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE };

    static double c = Double.MAX_VALUE;

    static double d = 0.1534053217674849;

    static int k = -636059804;

    int test_2vi_inv(double[] a, double[] b, double c, double d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14163().test_2vi_inv(a, b, c, d, k);
    }
}
