public class MyJVMTest_6418 {

    static short[] a = { 32767, -31739, 5206, 32767, 22513, -27291, 0, -32768, 0, -32768 };

    static short[] b = { 32767, 7038, 32767, 0, 32767, 0, -32768, -7816, 0, 32767 };

    static double[] c = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, 0.551403412311 };

    static double[] d = { Double.MIN_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE };

    static int ALIGN_OFF = 8;

    short[] test_cp_alndst(short[] a, short[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6418().test_cp_alndst(a, b, c, d);
    }
}
