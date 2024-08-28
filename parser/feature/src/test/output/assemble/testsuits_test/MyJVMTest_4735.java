public class MyJVMTest_4735 {

    static byte[] a = { 38, -69, 125, 4, -63, -109, 51, -92, -93, -64 };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, 0.2851385989454285, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    byte[] test_ci_oppos(byte[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4735().test_ci_oppos(a, b);
    }
}
