public class MyJVMTest_2965 {

    static double[] a = { Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d, 0d, 0d };

    static double[] b = { Double.POSITIVE_INFINITY, 0d, 0d, Double.NaN, Double.NaN, 0d, Double.NEGATIVE_INFINITY, Double.NaN, 0d, Double.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    double[] test_cp_unalnsrc(double[] a, double[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2965().test_cp_unalnsrc(a, b);
    }
}
