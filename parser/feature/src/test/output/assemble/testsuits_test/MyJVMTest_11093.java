public class MyJVMTest_11093 {

    static double[] a = { Double.MAX_VALUE, 0d, 0.8671473082085452, Double.NEGATIVE_INFINITY, 0.9592895912801845, 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN };

    static double[] b = { 0.23081891442658797, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, 0d, 0d, 0d, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static double[] c = { 0.0299232575726609, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE };

    static double[] d = { 0d, 0d, 0d, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.NaN, 0.5615374847531, Double.MAX_VALUE };

    static double total = Double.NEGATIVE_INFINITY;

    double sumReductionImplement(double[] a, double[] b, double[] c, double[] d, double total) {
        for (int i = 0; i < a.length; i++) {
            d[i] = Math.sqrt(a[i] * b[i]) + Math.sqrt(a[i] * c[i]) + Math.sqrt(b[i] * c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11093().sumReductionImplement(a, b, c, d, total));
    }
}
