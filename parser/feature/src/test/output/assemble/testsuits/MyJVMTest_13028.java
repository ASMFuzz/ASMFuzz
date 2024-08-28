public class MyJVMTest_13028 {

    static double[] a = { Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, 0.3019993658926896, Double.MIN_VALUE, 0.4505461381838961, Double.NaN, 0.04286634230282771, 0d, Double.POSITIVE_INFINITY };

    static double[] b = { Double.NaN, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.6807889306140613, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.21836767200139862, Double.NEGATIVE_INFINITY, 0d };

    static double[] c = { Double.NaN, 0.34878284560895134, 0.04654722145990753, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE };

    static double[] d = { 0.4075874574157037, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE };

    static double total = Double.NEGATIVE_INFINITY;

    double sumReductionImplement(double[] a, double[] b, double[] c, double[] d, double total) {
        for (int i = 0; i < a.length; i++) {
            d[i] = (a[i] * b[i]) + (a[i] * c[i]) + (b[i] * c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13028().sumReductionImplement(a, b, c, d, total));
    }
}
