public class MyJVMTest_4010 {

    static short[] a = { -32768, -7525, -16821, -32768, 0, 32767, -12247, 0, -32768, 4628 };

    static double[] b = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0.2731841080441445, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0d };

    static short c = 0;

    static double d = Double.NaN;

    static int ALIGN_OFF = 8;

    short[] test_vi_aln(short[] a, double[] b, short c, double d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4010().test_vi_aln(a, b, c, d);
    }
}
