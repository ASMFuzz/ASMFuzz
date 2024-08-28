public class MyJVMTest_9753 {

    static double[] a = { Double.NaN, 0d, Double.NaN, Double.MIN_VALUE, 0.16415084276068403, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, 0d };

    static double[] b = { Double.MAX_VALUE, 0.36455571405760834, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0.4450312560715135, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE };

    static int ALIGN_OFF = 8;

    double[] test_cp_alnsrc(double[] a, double[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9753().test_cp_alnsrc(a, b);
    }
}
