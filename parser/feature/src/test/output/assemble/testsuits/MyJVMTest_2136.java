public class MyJVMTest_2136 {

    static double[] a = { 0.5271404184636235, Double.MAX_VALUE, 0.5361421204934411, 0.3054065878220873, Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, 0d };

    static double[] b = { Double.POSITIVE_INFINITY, 0.400915832860094, Double.NEGATIVE_INFINITY, 0.9459472568397124, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.MAX_VALUE, Double.NEGATIVE_INFINITY };

    static int k = 5;

    int test_cp_inv(double[] a, double[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b[i + k];
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2136().test_cp_inv(a, b, k);
    }
}
