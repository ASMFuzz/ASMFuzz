public class MyJVMTest_10509 {

    static double[] a = { Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, 0.021535146889396062, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, 0d };

    static double[] b = { 0d, 0.17102785270915388, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, 0.8450316458075668, Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE };

    double[] test_cp_oppos(double[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10509().test_cp_oppos(a, b);
    }
}
