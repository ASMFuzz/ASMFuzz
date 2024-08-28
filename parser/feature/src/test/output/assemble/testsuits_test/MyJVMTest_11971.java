public class MyJVMTest_11971 {

    static int[] a = { 7, 1, 0, 4, 1288151391, 4, 7, 5, 0, 0 };

    static double[] b = { Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY };

    int[] test_ci_neg(int[] a, double[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11971().test_ci_neg(a, b);
    }
}
