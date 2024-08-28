public class MyJVMTest_13363 {

    static short[] a = { 0, 0, -32768, 32767, 0, -32768, 0, 32767, 32767, -32768 };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.NaN, 0.4428537550279038, Double.POSITIVE_INFINITY, Double.NaN, 0.08031110744989711, Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.MAX_VALUE };

    static short c = 32767;

    static double d = 0d;

    static int ALIGN_OFF = 8;

    short[] test_vi_aln(short[] a, double[] b, short c, double d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = c;
            b[i + ALIGN_OFF] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13363().test_vi_aln(a, b, c, d);
    }
}
