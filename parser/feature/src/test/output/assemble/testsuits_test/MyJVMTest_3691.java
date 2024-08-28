public class MyJVMTest_3691 {

    static double[] a = { Double.MAX_VALUE, 0.5459146286016171, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, 0d, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.07030844870390329 };

    static double[] b = { 0.21043881082507976, Double.NEGATIVE_INFINITY, 0.9038338419753419, 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, 0d, 0d, Double.MAX_VALUE };

    static double[] c = { 0.9526955032306429, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE };

    static double[] d = { Double.NaN, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.38466009483405617, 0d, 0.3938378151234918, Double.NaN, Double.MIN_VALUE };

    static double total = 0d;

    double sumReductionImplement(double[] a, double[] b, double[] c, double[] d, double total) {
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3691().sumReductionImplement(a, b, c, d, total));
    }
}
