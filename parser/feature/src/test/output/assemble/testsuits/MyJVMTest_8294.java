public class MyJVMTest_8294 {

    static double[] a = { Double.NEGATIVE_INFINITY, 0.7146234657918867, Double.POSITIVE_INFINITY, 0d, 0.7738159535785086, Double.NaN, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, 0d };

    static double[] b = { 0d, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, 0.6682791234868874, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0.7910905486669199 };

    static int k = 0;

    int test_2ci_inv(double[] a, double[] b, int k) {
        for (int i = 0; i < a.length - k; i += 1) {
            a[i + k] = -123.;
            b[i + k] = -103.;
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8294().test_2ci_inv(a, b, k);
    }
}
