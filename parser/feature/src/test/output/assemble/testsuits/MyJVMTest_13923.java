public class MyJVMTest_13923 {

    static double[] a = { Double.MIN_VALUE, Double.NaN, 0d, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, 0d, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static double[] b = { 0.6307412820058549, Double.MAX_VALUE, 0.908757596132028, 0d, Double.MAX_VALUE, 0.5725511256092014, Double.MIN_VALUE, Double.MAX_VALUE, 0.6961284803745144, 0d };

    static double c = Double.MAX_VALUE;

    static double d = Double.MIN_VALUE;

    static int OFFSET = 3;

    double[] test_2vi_off(double[] a, double[] b, double c, double d) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = c;
            b[i + OFFSET] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13923().test_2vi_off(a, b, c, d);
    }
}
