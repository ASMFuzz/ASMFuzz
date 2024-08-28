public class MyJVMTest_7166 {

    static byte[] a = { 85, -3, -57, -127, 105, -62, -110, 66, -41, -81 };

    static byte[] b = { 74, 106, -12, -50, 81, -40, 86, -58, -74, 88 };

    static double[] c = { 0d, Double.NaN, 0.19848708679394267, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, Double.NEGATIVE_INFINITY, 0d, 0.6601771247207958 };

    static double[] d = { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.4218747961466074, Double.NaN, 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alnsrc(byte[] a, byte[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7166().test_cp_alnsrc(a, b, c, d);
    }
}
