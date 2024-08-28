public class MyJVMTest_6199 {

    static double[] a = { Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, 0d, Double.MIN_VALUE };

    static double[] b = { Double.NEGATIVE_INFINITY, 0d, Double.MIN_VALUE, Double.MIN_VALUE, 0d, 0.5365446357163661, 0d, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    static double c = Double.MIN_VALUE;

    static double d = Double.POSITIVE_INFINITY;

    static int ALIGN_OFF = 8;

    double[] test_2vi_aln(double[] a, double[] b, double c, double d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6199().test_2vi_aln(a, b, c, d);
    }
}
