public class MyJVMTest_10633 {

    static double[] a = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.6317649948327125, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NaN };

    static double[] b = { 0d, Double.MAX_VALUE, 0.888238506724214, Double.POSITIVE_INFINITY, 0.3842636654544347, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY };

    double[] prodReductionInit(double[] a, double[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 2;
            b[i] = i + 1;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10633().prodReductionInit(a, b);
    }
}
