public class MyJVMTest_3410 {

    static double[] a0 = { 0.9789574520782259, 0d, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN };

    static double[] a1 = { Double.MAX_VALUE, Double.MAX_VALUE, 0.7896478903264307, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE, 0.9530870603527943, Double.NaN };

    double[] test_unrl_divi(double[] a0, double[] a1) {
        int i = 0;
        for (; i < a0.length - 4; i += 4) {
            a0[i + 0] = a1[i + 0] / 1.;
            a0[i + 1] = a1[i + 1] / 2.;
            a0[i + 2] = a1[i + 2] / 3.;
            a0[i + 3] = a1[i + 3] / 4.;
        }
        for (; i < a0.length; i++) {
            a0[i] = a1[i] / (double) ((i & 3) + 1);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3410().test_unrl_divi(a0, a1);
    }
}
