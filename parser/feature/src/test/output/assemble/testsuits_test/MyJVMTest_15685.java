public class MyJVMTest_15685 {

    static short[] a = { 0, 10117, 1689, 0, 32767, -4602, 14139, -32768, -32768, -32768 };

    static double[] b = { Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, 0d, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0.5258619599414665 };

    static short c = -2037;

    static double d = Double.NaN;

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_vi_unaln(short[] a, double[] b, short c, double d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + UNALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15685().test_vi_unaln(a, b, c, d);
    }
}
