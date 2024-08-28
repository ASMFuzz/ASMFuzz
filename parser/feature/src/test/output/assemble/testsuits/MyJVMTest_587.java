public class MyJVMTest_587 {

    static double[] a = { Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static double[] b = { Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0.2669968541679799 };

    static int ALIGN_OFF = 8;

    double[] test_cp_alnsrc(double[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_587().test_cp_alnsrc(a, b);
    }
}
