public class MyJVMTest_16461 {

    static double[] a = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.570599780466075, 0.255117653015308, Double.MIN_VALUE, Double.MAX_VALUE, 0.7933567272704415 };

    static double b = Double.MAX_VALUE;

    double[] test_vi(double[] a, double b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16461().test_vi(a, b);
    }
}
