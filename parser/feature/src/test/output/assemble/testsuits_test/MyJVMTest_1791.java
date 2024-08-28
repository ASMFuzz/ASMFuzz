public class MyJVMTest_1791 {

    static double[] a0 = { Double.NaN, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.MIN_VALUE, Double.NaN, 0d, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    double[] test_unrl_init(double[] a0) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = 0.;
            a0[i + 1] = 1.;
            a0[i + 2] = 2.;
            a0[i + 3] = 3.;
        }
        for (; i < a0.length; i++) {
            a0[i] = (double) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1791().test_unrl_init(a0);
    }
}
