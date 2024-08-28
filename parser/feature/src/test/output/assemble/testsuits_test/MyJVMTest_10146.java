public class MyJVMTest_10146 {

    static double[] d1 = { Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0d, 0d, 0.5983892414748154, 0.8273400572177094, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY };

    static double[] d2 = { Double.MIN_VALUE, 0.02782498691632529, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, 0.2927503353922324, 0.25779879150683416, Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY };

    static double[] d3 = { Double.MAX_VALUE, 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.8375190140084663, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NaN };

    double sumDouble(double[] d1, double[] d2, double[] d3) {
        double total = 0;
        for (int i = 0; i < d1.length; i++) {
            total += (d1[i] * d2[i]) + (d1[i] * d3[i]) + (d2[i] * d3[i]);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10146().sumDouble(d1, d2, d3));
    }
}
