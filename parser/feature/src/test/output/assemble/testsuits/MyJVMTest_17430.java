public class MyJVMTest_17430 {

    static byte[] a = { -71, 17, -41, 98, -21, 27, 116, -84, 93, -56 };

    static double[] b = { Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0d, 0d, 0.17388513541469985, 0d };

    byte[] test_ci(byte[] a, double[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17430().test_ci(a, b);
    }
}
