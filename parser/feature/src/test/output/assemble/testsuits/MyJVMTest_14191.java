public class MyJVMTest_14191 {

    static short[] a = { 32767, -32768, -32768, 32767, 32767, -32768, 0, 0, -32768, 32767 };

    static short[] b = { 32767, 0, -9463, 32767, 3905, -32768, 32767, 0, -32768, 32767 };

    static double[] c = { Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, 0d, 0.9418921034594537, Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.5767271780592186 };

    static double[] d = { 0.8466950485751076, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, 0d, 0.5464799257328017 };

    short[] test_cp_neg(short[] a, short[] b, double[] c, double[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14191().test_cp_neg(a, b, c, d);
    }
}
