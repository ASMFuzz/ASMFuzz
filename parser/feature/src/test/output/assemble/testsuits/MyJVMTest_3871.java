public class MyJVMTest_3871 {

    static short[] a = { 28475, 3814, 0, 0, 0, 0, -32768, 10351, 18393, 0 };

    static short[] b = { 4849, 0, 0, -32768, -32768, 0, -32768, 0, -32768, 32767 };

    static double[] c = { Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, 0d, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE };

    static double[] d = { 0.06893604099949979, 0.002397708489146222, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.NaN, 0d, Double.NaN, Double.NaN };

    short[] test_cp(short[] a, short[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3871().test_cp(a, b, c, d);
    }
}
