public class MyJVMTest_1305 {

    static double[] a = { Double.NaN, Double.MIN_VALUE, 0.23201160963268608, 0d, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN };

    static double[] b = { Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0d, Double.NaN, Double.POSITIVE_INFINITY, 0.9218288775434181, Double.MAX_VALUE };

    double[] test_cp_oppos(double[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1305().test_cp_oppos(a, b);
    }
}
