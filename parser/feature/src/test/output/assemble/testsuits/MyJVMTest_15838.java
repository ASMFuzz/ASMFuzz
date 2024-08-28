public class MyJVMTest_15838 {

    static int[] a = { 8, 0, 0, 6, 0, 6, -1832485354, 6, 0, 0 };

    static double[] b = { 0.5184871744665754, 0d, 0d, Double.NaN, 0d, Double.NaN, 0.2044010591937716, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    int[] test_ci_unaln(int[] a, double[] b) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15838().test_ci_unaln(a, b);
    }
}
