public class MyJVMTest_18037 {

    static double[] a = { 0.3762067609766938, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, 0.13883253179884736, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double[] b = { 0.38427942251470537, 0d, 0d, Double.POSITIVE_INFINITY, 0.1749551260282397, 0d, Double.MAX_VALUE, 0.25565363537673225, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    static double c = Double.POSITIVE_INFINITY;

    static double d = 0d;

    static int SCALE = 2;

    double[] test_2vi_scl(double[] a, double[] b, double c, double d) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = c;
            b[i * SCALE] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18037().test_2vi_scl(a, b, c, d);
    }
}
