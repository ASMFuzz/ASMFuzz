public class MyJVMTest_15164 {

    static double[] a0 = { Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0.871887700180298, Double.NaN, Double.NEGATIVE_INFINITY, 0d, Double.MIN_VALUE, 0d };

    static double[] a1 = { 0.7846882213010089, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, 0.928397846042602, Double.MIN_VALUE };

    double[] test_divi(double[] a0, double[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = a1[i] / (double) ((i & 3) + 1);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15164().test_divi(a0, a1);
    }
}
