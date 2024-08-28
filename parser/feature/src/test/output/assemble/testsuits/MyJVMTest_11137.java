public class MyJVMTest_11137 {

    static double[] a = { 0.38242492678304685, 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0.13169947422213424, 0.38974739519364243, 0.5592857784215352, Double.POSITIVE_INFINITY, Double.NaN, Double.MIN_VALUE };

    static double[] b = { Double.POSITIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double total = 0d;

    double prodReductionImplement(double[] a, double[] b, double total) {
        for (int i = 0; i < a.length; i++) {
            total *= a[i] - b[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11137().prodReductionImplement(a, b, total));
    }
}
