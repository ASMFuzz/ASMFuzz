public class MyJVMTest_15790 {

    static short[] a = { 32767, 0, -32768, 32767, 32767, -32768, 4452, 0, -24303, 0 };

    static short[] b = { 14219, 0, 32767, 0, 0, -14605, 7597, 2401, 0, 32767 };

    static double[] c = { Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, 0.2520053525318864, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    static double[] d = { Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN, 0d, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, 0.11184719325336667, Double.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalndst(short[] a, short[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15790().test_cp_unalndst(a, b, c, d);
    }
}
