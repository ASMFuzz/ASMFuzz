public class MyJVMTest_15672 {

    static double[] a = { Double.MIN_VALUE, 0.3802020517275079, 0d, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.NaN, 0.6984379294270999, 0.4998483816834577 };

    static double[] b = { 0.289459476431276, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.12927289957052412, 0d, 0d };

    static double c = 0.9469848493412324;

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
        new MyJVMTest_15672().test_2vi_aln(a, b, c, d);
    }
}
