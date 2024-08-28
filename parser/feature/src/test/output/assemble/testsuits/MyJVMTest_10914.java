public class MyJVMTest_10914 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.NaN, Double.NEGATIVE_INFINITY, 0.5420237923212714, Double.NEGATIVE_INFINITY, Double.MAX_VALUE };

    static int OFFSET = 3;

    double[] test_ci_off(double[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = -123.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10914().test_ci_off(a);
    }
}
