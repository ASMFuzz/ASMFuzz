public class MyJVMTest_6543 {

    static short[] a = { -32768, -32768, -24048, -32768, 0, 32767, 0, 0, 30481, 0 };

    static short[] b = { 0, -32768, 32767, 32767, -32768, 32767, -32768, -32768, 0, -1740 };

    static double[] c = { Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, 0.5003339246139387, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, 0.8220217996599893, Double.MAX_VALUE, 0d };

    static double[] d = { Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, 0.7514732988937626, Double.NEGATIVE_INFINITY, 0.2340674530374005, Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d };

    static int ALIGN_OFF = 8;

    short[] test_cp_alnsrc(short[] a, short[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6543().test_cp_alnsrc(a, b, c, d);
    }
}
