public class MyJVMTest_5861 {

    static short[] a = { 12227, -32768, 0, 0, -32768, 0, 32767, 0, 1491, 0 };

    static double[] b = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY, 0d };

    static int ALIGN_OFF = 8;

    short[] test_ci_aln(short[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5861().test_ci_aln(a, b);
    }
}
