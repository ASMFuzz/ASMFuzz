public class MyJVMTest_16689 {

    static byte[] a = { -74, -32, -122, 4, 34, 48, 83, 66, -52, -79 };

    static byte[] b = { 10, -106, 125, -38, 103, -121, -16, -55, -124, 43 };

    static double[] c = { 0.13774583102482763, 0.7696234168436267, 0.724667055260128, Double.MAX_VALUE, 0d, 0d, Double.NaN, Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE };

    static double[] d = { Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.9039957545975512, Double.POSITIVE_INFINITY, 0d, Double.NaN };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alnsrc(byte[] a, byte[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16689().test_cp_alnsrc(a, b, c, d);
    }
}
