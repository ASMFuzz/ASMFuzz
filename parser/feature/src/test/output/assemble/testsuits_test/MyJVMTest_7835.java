public class MyJVMTest_7835 {

    static double[] a = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, 0d, Double.NaN, 0.671642855495159, 0d, Double.MAX_VALUE };

    static int SCALE = 2;

    double[] test_ci_scl(double[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = -123.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7835().test_ci_scl(a);
    }
}
