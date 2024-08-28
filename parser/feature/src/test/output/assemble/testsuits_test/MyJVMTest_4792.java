public class MyJVMTest_4792 {

    static short[] a = { -32768, 27786, 32767, -32768, 32767, 32767, 32767, 32767, -32768, -21917 };

    static short[] b = { -25861, 0, 0, 0, 0, 17962, 0, -22047, 32767, 32767 };

    static double[] c = { Double.NEGATIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, 0.13931498616110904, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, 0d, 0d, 0d };

    static double[] d = { Double.NaN, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, 0.1957652499975885, Double.MAX_VALUE, 0.4466040849831987, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE };

    short[] test_cp_neg(short[] a, short[] b, double[] c, double[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4792().test_cp_neg(a, b, c, d);
    }
}
