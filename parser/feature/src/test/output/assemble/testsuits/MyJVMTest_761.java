public class MyJVMTest_761 {

    static byte[] a = { 13, -20, -74, -91, 65, -14, 66, -40, -75, -15 };

    static byte[] b = { 126, 39, -116, -114, 125, 44, -14, -80, 51, -66 };

    static double[] c = { Double.NaN, Double.MIN_VALUE, 0d, 0d, 0.4675770764526713, 0d, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, 0.9929955454918532 };

    static double[] d = { 0d, Double.MIN_VALUE, 0.9186232227331534, 0.3589313463175393, 0d, 0d, Double.POSITIVE_INFINITY, Double.NaN, 0.6750513093777745, Double.MAX_VALUE };

    byte[] test_cp(byte[] a, byte[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_761().test_cp(a, b, c, d);
    }
}
