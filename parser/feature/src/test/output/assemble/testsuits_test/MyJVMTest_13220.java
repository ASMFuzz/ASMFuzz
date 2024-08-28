public class MyJVMTest_13220 {

    static double[] a = { Double.MAX_VALUE, 0.8556520035545471, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.06466723468775137, Double.MIN_VALUE, Double.NaN, 0d, Double.MAX_VALUE, 0d };

    double[] test_ci_oppos(double[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13220().test_ci_oppos(a);
    }
}
