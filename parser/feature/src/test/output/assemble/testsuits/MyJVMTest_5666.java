public class MyJVMTest_5666 {

    static byte[] a = { 117, 8, -25, 8, -28, -51, 25, 34, -57, -71 };

    static double[] b = { Double.MIN_VALUE, 0d, Double.MIN_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0.54376028422319, Double.NaN, Double.NEGATIVE_INFINITY, 0d };

    static byte c = 55;

    static double d = Double.POSITIVE_INFINITY;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_vi_unaln(byte[] a, double[] b, byte c, double d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5666().test_vi_unaln(a, b, c, d);
    }
}
