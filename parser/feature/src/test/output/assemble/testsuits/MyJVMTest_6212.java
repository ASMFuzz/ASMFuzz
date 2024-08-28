public class MyJVMTest_6212 {

    static short[] a = { -23612, 0, -32768, 32767, -32768, 32767, -32768, -32768, -32768, -32768 };

    static double[] b = { Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, 0.19992180326318298, Double.NaN, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0.2910840327848446 };

    static short c = 0;

    static double d = Double.POSITIVE_INFINITY;

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
        new MyJVMTest_6212().test_vi_unaln(a, b, c, d);
    }
}
