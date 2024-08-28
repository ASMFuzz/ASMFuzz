public class MyJVMTest_1903 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.NaN, 0.9266329447381692, 0d, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.NaN, 0.8226668235843668 };

    static double[] b = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.MAX_VALUE, 0.10746059687264564, 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d, Double.NaN };

    static double total = Double.NEGATIVE_INFINITY;

    double prodReductionImplement(double[] a, double[] b, double total) {
        for (int i = 0; i < a.length; i++) {
            total *= a[i] - b[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1903().prodReductionImplement(a, b, total));
    }
}
