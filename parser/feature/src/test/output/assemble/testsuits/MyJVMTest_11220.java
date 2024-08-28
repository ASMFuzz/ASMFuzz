public class MyJVMTest_11220 {

    static int[] a = { 1, 5, 8, 0, 9, 7, 0, -1115575764, 1471157035, 5 };

    static double[] b = { Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.NaN, 0.7743990978189487, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    int[] test_ci_aln(int[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11220().test_ci_aln(a, b);
    }
}
