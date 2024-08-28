public class MyJVMTest_2424 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, 0.8715535860042701, 0.05408633671803409, 0d, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN };

    static double b = Double.MAX_VALUE;

    static int k = -182679391;

    int test_vi_inv(double[] a, double b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = b;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2424().test_vi_inv(a, b, k);
    }
}
