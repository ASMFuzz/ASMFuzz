public class MyJVMTest_2373 {

    static double[] a = { 0.858623208216185, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.19756160103583165 };

    static double[] b = { Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY };

    static double[] c = { Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

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
        new MyJVMTest_2373().sumReductionInit(a, b, c);
    }
}
