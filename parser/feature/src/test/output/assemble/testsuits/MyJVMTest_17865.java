public class MyJVMTest_17865 {

    static double[] d1 = { 0.7944498309768014, 0.04524081864059848, Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, 0d, Double.MAX_VALUE, 0d };

    static double[] d2 = { Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN, 0.2723547118216446, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, 0.028777903957512896, 0d, 0.17606675375570857 };

    static double[] d3 = { 0d, Double.NEGATIVE_INFINITY, 0.6487182615690942, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0.11744038192005457 };

    double prodDouble(double[] d1, double[] d2, double[] d3) {
        double total = 1;
        for (int i = 0; i < d1.length; i++) {
            total *= (d1[i] * d2[i]) + (d1[i] * d3[i]) + (d2[i] * d3[i]);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17865().prodDouble(d1, d2, d3));
    }
}
