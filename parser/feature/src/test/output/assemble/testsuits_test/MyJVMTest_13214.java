public class MyJVMTest_13214 {

    static short[] a = { 32767, 0, 32767, 6014, 32767, 32767, 0, -32017, 13705, 32767 };

    static short[] b = { -32768, -32768, 32767, -32768, 2311, -32768, -10604, 32767, 0, 0 };

    static double[] c = { Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static double[] d = { 0d, 0.8875719960794219, Double.NaN, 0d, Double.MIN_VALUE, 0d, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE };

    short[] test_cp(short[] a, short[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13214().test_cp(a, b, c, d);
    }
}
