public class MyJVMTest_17820 {

    static short[] a = { -32768, 32767, -32768, -32768, -32768, -32768, 32767, 0, 0, 0 };

    static short[] b = { 32767, 32767, 0, 32767, -23616, 32767, 0, 32767, 9544, -7401 };

    static double[] c = { Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, 0.14521986007422405, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0d, Double.MAX_VALUE };

    static double[] d = { 0.473789624170566, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.06889058777187484, 0d, Double.MAX_VALUE, 0d, Double.NaN, Double.NEGATIVE_INFINITY, 0.37605244215306344 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    short[] test_cp_unalnsrc(short[] a, short[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17820().test_cp_unalnsrc(a, b, c, d);
    }
}
