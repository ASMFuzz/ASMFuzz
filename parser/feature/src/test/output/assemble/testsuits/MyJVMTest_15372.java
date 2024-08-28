public class MyJVMTest_15372 {

    static byte[] a = { 123, 121, 53, -48, -53, -71, -55, -47, 104, 40 };

    static double[] b = { Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, 0.5212647634489954, Double.NaN, 0d, Double.POSITIVE_INFINITY, 0.40061559465387553, Double.MIN_VALUE };

    static byte c = 127;

    static double d = 0.3244895960226727;

    byte[] test_vi(byte[] a, double[] b, byte c, double d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15372().test_vi(a, b, c, d);
    }
}
