public class MyJVMTest_3876 {

    static double[] a = { Double.NEGATIVE_INFINITY, 0.9846189248654488, Double.POSITIVE_INFINITY, 0.07583507519574739, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0d, 0.3450533512049411, Double.NaN, 0.6416438240991638 };

    double[] test_ci_oppos(double[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3876().test_ci_oppos(a);
    }
}
