public class MyJVMTest_6089 {

    static double[] a0 = { Double.MAX_VALUE, Double.NaN, Double.NaN, 0.37882904782755267, Double.POSITIVE_INFINITY, 0d, Double.NaN, 0.9261667830594816, Double.POSITIVE_INFINITY, Double.MAX_VALUE };

    double[] test_init(double[] a0) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (double) (i & 3);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6089().test_init(a0);
    }
}
