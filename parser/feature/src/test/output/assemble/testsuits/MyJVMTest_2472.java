public class MyJVMTest_2472 {

    static byte[] a = { 26, -73, 101, 9, -61, -4, -41, 117, -49, -71 };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, 0d, Double.NaN, Double.NaN };

    static byte c = 127;

    static double d = 0.4735428501833131;

    static int ALIGN_OFF = 8;

    byte[] test_vi_aln(byte[] a, double[] b, byte c, double d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2472().test_vi_aln(a, b, c, d);
    }
}
