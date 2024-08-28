public class MyJVMTest_15903 {

    static short[] a = { -2676, 0, -32768, 0, 32767, 0, 7651, 0, 0, -32768 };

    static short[] b = { 32767, -32768, -32768, 12567, 0, -32768, 32767, 16249, 0, -32768 };

    static double[] c = { Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, 0d, Double.MAX_VALUE, 0d, 0d, Double.POSITIVE_INFINITY };

    static double[] d = { Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0.6980137029791188, 0.7692651356234047, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE };

    static int ALIGN_OFF = 8;

    short[] test_cp_alndst(short[] a, short[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15903().test_cp_alndst(a, b, c, d);
    }
}
