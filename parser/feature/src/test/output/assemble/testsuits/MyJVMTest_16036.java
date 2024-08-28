public class MyJVMTest_16036 {

    static short[] a = { 31742, -23098, 0, -32768, 32767, 32767, -32768, 0, -23822, 0 };

    static short[] b = { 0, 0, 32767, 0, 32767, -32768, 32767, -32768, -511, 32767 };

    static double[] c = { Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, 0.761701480371099, Double.NaN };

    static double[] d = { Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.NaN, 0.681847403583078, 0d, Double.POSITIVE_INFINITY, Double.NaN };

    static int ALIGN_OFF = 8;

    short[] test_cp_alnsrc(short[] a, short[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16036().test_cp_alnsrc(a, b, c, d);
    }
}
