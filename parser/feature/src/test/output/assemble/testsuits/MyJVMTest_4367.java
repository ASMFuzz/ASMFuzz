public class MyJVMTest_4367 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY };

    static double[] b = { Double.MIN_VALUE, 0.7963976762585434, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, 0.441259670703135, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    double[] test_cp_unalndst(double[] a, double[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4367().test_cp_unalndst(a, b);
    }
}
