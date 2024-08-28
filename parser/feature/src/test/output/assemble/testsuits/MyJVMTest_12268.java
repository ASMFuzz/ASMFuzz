public class MyJVMTest_12268 {

    static double[] a = { Double.NaN, Double.MIN_VALUE, Double.NaN, 8.343423073307044E-4, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double[] b = { Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    double[] test_cp_unalnsrc(double[] a, double[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12268().test_cp_unalnsrc(a, b);
    }
}
