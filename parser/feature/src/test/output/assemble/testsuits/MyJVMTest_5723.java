public class MyJVMTest_5723 {

    static double[] a0 = { Double.NaN, 0d, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, 0.7711818676072493, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    static double[] a1 = { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0.7703573848816183, Double.NaN, 0.37836397899888496, Double.NaN, Double.MIN_VALUE, 0.10214514331164515 };

    double[] test_divi(double[] a0, double[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = a1[i] / (double) ((i & 3) + 1);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5723().test_divi(a0, a1);
    }
}
