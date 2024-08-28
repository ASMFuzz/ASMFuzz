public class MyJVMTest_14133 {

    static byte[] a = { 21, 75, -2, 74, -91, -69, -18, -83, 108, -47 };

    static double[] b = { Double.NaN, 0d, Double.NaN, 0.061827917389277176, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY };

    byte[] test_ci_oppos(byte[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14133().test_ci_oppos(a, b);
    }
}
