public class MyJVMTest_1692 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0.22455232345512077, 0.5175862582124879, 0d, Double.MAX_VALUE };

    static int OFFSET = 3;

    double[] test_ci_off(double[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1692().test_ci_off(a);
    }
}
