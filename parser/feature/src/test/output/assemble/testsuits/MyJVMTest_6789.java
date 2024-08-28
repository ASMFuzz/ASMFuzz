public class MyJVMTest_6789 {

    static double[] a0 = { Double.NEGATIVE_INFINITY, 0d, Double.MIN_VALUE, 0.1260934765849525, 0d, Double.MAX_VALUE, Double.MIN_VALUE, 0.1151283749833879, 0.20002415379249905, Double.MIN_VALUE };

    static double[] a1 = { 0.374696296930192, Double.MAX_VALUE, 0d, Double.NaN, 0d, Double.MIN_VALUE, Double.NaN, 0d, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    double[] test_addi(double[] a0, double[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = a1[i] + (double) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6789().test_addi(a0, a1);
    }
}
