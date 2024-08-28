public class MyJVMTest_5071 {

    static double[] a = { 0d, Double.POSITIVE_INFINITY, Double.NaN, 0.914332879180049, Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN };

    static double[] b = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.9002137247235039, 0d, Double.POSITIVE_INFINITY, Double.NaN, Double.MIN_VALUE, 0.751596068815067, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    double[] test_2ci_unaln(double[] a, double[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123.;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5071().test_2ci_unaln(a, b);
    }
}
