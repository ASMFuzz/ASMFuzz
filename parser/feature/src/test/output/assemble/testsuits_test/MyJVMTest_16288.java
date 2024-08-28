public class MyJVMTest_16288 {

    static double[] a0 = { Double.POSITIVE_INFINITY, 0.938746110690887, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, 0.49818453088082926, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    static double[] a1 = { Double.NaN, 0d, Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.NaN, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.NaN };

    double[] test_addi(double[] a0, double[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = a1[i] + (double) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16288().test_addi(a0, a1);
    }
}
