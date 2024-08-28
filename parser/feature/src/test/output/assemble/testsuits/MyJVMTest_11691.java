public class MyJVMTest_11691 {

    static double[] a = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE };

    static double b = Double.POSITIVE_INFINITY;

    static int k = 6;

    int test_vi_inv(double[] a, double b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11691().test_vi_inv(a, b, k);
    }
}
