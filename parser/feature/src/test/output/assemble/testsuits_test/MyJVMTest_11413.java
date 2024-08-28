public class MyJVMTest_11413 {

    static double[] a0 = { Double.MIN_VALUE, Double.MAX_VALUE, 0.6160954178180501, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.MAX_VALUE, 0.8054532279186704 };

    static double[] a1 = { Double.NaN, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, 0.723664742801754, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

    double[] test_unrl_addi(double[] a0, double[] a1) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = a1[i + 0] + 0.;
            a0[i + 1] = a1[i + 1] + 1.;
            a0[i + 2] = a1[i + 2] + 2.;
            a0[i + 3] = a1[i + 3] + 3.;
        }
        for (; i < a0.length; i++) {
            a0[i] = a1[i] + (double) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11413().test_unrl_addi(a0, a1);
    }
}
