public class MyJVMTest_11 {

    static byte[] a = { 13, -74, 45, 64, 33, 122, -92, 20, 30, 61 };

    static byte[] b = { 3, -7, -34, -19, -38, -71, -110, 119, -40, 30 };

    static double[] c = { Double.NEGATIVE_INFINITY, 0.10461857799548335, Double.MIN_VALUE, 0.06387281359246266, Double.NaN, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.6355837372884815, Double.NEGATIVE_INFINITY };

    static double[] d = { Double.MIN_VALUE, 0.6442355074329242, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalnsrc(byte[] a, byte[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11().test_cp_unalnsrc(a, b, c, d);
    }
}
