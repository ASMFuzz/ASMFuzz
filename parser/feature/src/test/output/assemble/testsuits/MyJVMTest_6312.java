public class MyJVMTest_6312 {

    static short[] a = { -32768, -15031, 0, 32767, -32768, -20907, -12154, 32767, 0, 32767 };

    static short[] b = { 0, 32767, 32767, -32768, -32768, 0, 0, -32768, 0, -32768 };

    static double[] c = { Double.MAX_VALUE, Double.NaN, 0.3205574393451741, Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double[] d = { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, Double.MIN_VALUE, 0d };

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
        new MyJVMTest_6312().test_cp_unalndst(a, b, c, d);
    }
}
