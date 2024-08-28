public class MyJVMTest_961 {

    static double[] d1 = { Double.MIN_VALUE, Double.MIN_VALUE, 0d, Double.NaN, Double.MIN_VALUE, 0.299956345500039, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    static double[] d2 = { Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, 0d, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, 0d };

    static double[] d3 = { Double.NaN, Double.MIN_VALUE, Double.NaN, 0d, Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0.2639948668809403, Double.NEGATIVE_INFINITY, Double.MIN_VALUE };

    double sumDouble(double[] d1, double[] d2, double[] d3) {
        double total = 0;
        for (int i = 0; i < d1.length; i++) {
            total += (d1[i] * d2[i]) + (d1[i] * d3[i]) + (d2[i] * d3[i]);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_961().sumDouble(d1, d2, d3));
    }
}
