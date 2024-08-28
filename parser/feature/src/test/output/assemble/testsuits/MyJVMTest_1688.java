public class MyJVMTest_1688 {

    static double[] a = { 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, 0d };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.NaN, 0.9052784988241585, 0.9236753734565051, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0.12469665218172121 };

    static int SCALE = 2;

    double[] test_cp_scl(double[] a, double[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b[i * SCALE];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1688().test_cp_scl(a, b);
    }
}
