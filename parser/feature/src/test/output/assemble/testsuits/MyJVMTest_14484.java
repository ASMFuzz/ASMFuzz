public class MyJVMTest_14484 {

    static double[] a = { Double.MAX_VALUE, 0.25176524921912014, Double.POSITIVE_INFINITY, Double.NaN, 0.3163273003474456, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d, Double.MAX_VALUE, 0d };

    static double[] b = { 0.491474371180732, Double.POSITIVE_INFINITY, 0.29472878861397156, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, 0d, 0d };

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
        new MyJVMTest_14484().test_2ci_unaln(a, b);
    }
}
