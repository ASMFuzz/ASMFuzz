public class MyJVMTest_1420 {

    static double[] a = { Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, 0d, Double.NaN };

    static double[] b = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.4612436249016356, Double.NaN, Double.MIN_VALUE };

    double[] prodReductionInit(double[] a, double[] b) {
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 2;
            b[i] = i + 1;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1420().prodReductionInit(a, b);
    }
}
