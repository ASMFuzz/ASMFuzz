public class MyJVMTest_17585 {

    static double[] a = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, 0d, 0.6855607432881305, Double.NaN, Double.POSITIVE_INFINITY, 0d };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0d, Double.MIN_VALUE, 0d, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE };

    static double c = Double.POSITIVE_INFINITY;

    static double d = Double.POSITIVE_INFINITY;

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
        new MyJVMTest_17585().test_2vi_unaln(a, b, c, d);
    }
}
