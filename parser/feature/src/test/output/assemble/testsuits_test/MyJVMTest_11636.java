public class MyJVMTest_11636 {

    static double[] a = { Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, 0d, Double.NEGATIVE_INFINITY, 0.9932971908564829 };

    static double[] b = { Double.NaN, 0.949091982451537, 0d, Double.NaN, Double.MAX_VALUE, 0d, 0d, 0d, 0d, Double.NaN };

    static double[] c = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE };

    double[] sumReductionInit(double[] a, double[] b, double[] c) {
        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = i * 1 + j;
                b[i] = i * 1 - j;
                c[i] = i + j;
            }
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11636().sumReductionInit(a, b, c);
    }
}
