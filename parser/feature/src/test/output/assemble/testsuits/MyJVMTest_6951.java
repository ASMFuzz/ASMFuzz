public class MyJVMTest_6951 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, 0.7661060178608669, 0.28518957976903003, Double.POSITIVE_INFINITY };

    static double b = 0.7457204232559967;

    double[] test_vi(double[] a, double b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6951().test_vi(a, b);
    }
}
