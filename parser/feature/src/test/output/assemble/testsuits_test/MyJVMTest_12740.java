public class MyJVMTest_12740 {

    static double[] a0 = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.0077266610399958635, 0d, 0d, 0.9146729702761486, Double.NaN, Double.MIN_VALUE };

    static double[] a1 = { 0d, 0d, 0.4989226521887865, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, 0d, 0d };

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
        new MyJVMTest_12740().test_unrl_divi(a0, a1);
    }
}
