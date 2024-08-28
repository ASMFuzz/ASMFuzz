public class MyJVMTest_9148 {

    static byte[] a = { 5, 50, -78, -118, -62, 37, 56, 60, 71, -35 };

    static byte[] b = { -105, -100, -62, -95, 105, 52, -4, 41, -35, -12 };

    static double[] c = { Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, 0.48870047701548824, 0d, 0.26362904212770977, 0d, Double.NaN, Double.NaN, 0d };

    static double[] d = { 0d, Double.POSITIVE_INFINITY, Double.NaN, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.9342739550710357, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN };

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
        new MyJVMTest_9148().test_cp_unalnsrc(a, b, c, d);
    }
}
