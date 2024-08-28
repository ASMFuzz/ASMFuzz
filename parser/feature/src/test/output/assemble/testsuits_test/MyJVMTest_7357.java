public class MyJVMTest_7357 {

    static double[] a = { Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, 0d, Double.NEGATIVE_INFINITY, 0.5626327979850919, 0d, Double.MAX_VALUE, Double.NaN };

    static double[] b = { Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, 0.6669680023025361, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE };

    static double[] c = { Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, 0.8250673899163653, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, 0.19511750772382763 };

    static double[] d = { 0.9633462907148936, Double.NaN, Double.NEGATIVE_INFINITY, 0d, Double.MIN_VALUE, Double.MIN_VALUE, 0.1890368846894237, Double.NEGATIVE_INFINITY, Double.NaN, 0.5171181992389691 };

    static double total = Double.MAX_VALUE;

    double sumReductionImplement(double[] a, double[] b, double[] c, double[] d, double total) {
        for (int i = 0; i < a.length; i++) {
            d[i] = Math.abs(-a[i] * -b[i]) + Math.abs(-a[i] * -c[i]) + Math.abs(-b[i] * -c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7357().sumReductionImplement(a, b, c, d, total));
    }
}
