public class MyJVMTest_15308 {

    static short[] a = { -4887, 0, -32768, 32767, 18750, 32767, -32768, -32768, -32768, 23887 };

    static double[] b = { 0d, 0.5656572632154624, Double.MAX_VALUE, Double.MIN_VALUE, 0d, 0.7336646412972027, Double.NaN, 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE };

    static int ALIGN_OFF = 8;

    short[] test_ci_aln(short[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15308().test_ci_aln(a, b);
    }
}
