public class MyJVMTest_4765 {

    static double[] a = { 0.8107756960986341, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0d, Double.NEGATIVE_INFINITY };

    static double[] b = { 0d, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, 0d, 0d, Double.MIN_VALUE, 0.69931919697442, Double.MIN_VALUE };

    static double c = Double.POSITIVE_INFINITY;

    static double d = 0.7852564830524926;

    static int k = 0;

    int test_2vi_inv(double[] a, double[] b, double c, double d, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = c;
            b[i + k] = d;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4765().test_2vi_inv(a, b, c, d, k);
    }
}
