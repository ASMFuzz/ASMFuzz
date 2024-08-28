public class MyJVMTest_2161 {

    static double[] a0 = { Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, 0.21383585351936474, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0.06513852566684153 };

    static double[] a1 = { Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, 0d, Double.NaN, Double.NaN };

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
        new MyJVMTest_2161().test_unrl_addi(a0, a1);
    }
}
