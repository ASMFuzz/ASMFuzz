public class MyJVMTest_8018 {

    static double[] a = { 0d, 0.12457599778598005, 0.49395003338690635, Double.NaN, 0d, Double.MAX_VALUE, 0.8141701338156269, Double.MIN_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY };

    static double[] b = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.NaN, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d };

    static double c = Double.POSITIVE_INFINITY;

    static double d = Double.MIN_VALUE;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    double[] test_2vi_unaln(double[] a, double[] b, double c, double d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8018().test_2vi_unaln(a, b, c, d);
    }
}
