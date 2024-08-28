public class MyJVMTest_8289 {

    static double[] d1 = { 0d, Double.MIN_VALUE, Double.MAX_VALUE, 0.7147335468929057, Double.NEGATIVE_INFINITY, 0.24372929253373254, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE };

    static double[] d2 = { 0d, Double.POSITIVE_INFINITY, 0d, 0d, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.5259194403090881 };

    static double[] d3 = { Double.NEGATIVE_INFINITY, 0d, 0d, 0.8779566284828587, 0.6682531517126876, Double.MAX_VALUE, 0.8757248736803587, 0.3440176337830684, Double.NaN, Double.NEGATIVE_INFINITY };

    double prodDouble(double[] d1, double[] d2, double[] d3) {
        double total = 1;
        for (int i = 0; i < d1.length; i++) {
            total *= (d1[i] * d2[i]) + (d1[i] * d3[i]) + (d2[i] * d3[i]);
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8289().prodDouble(d1, d2, d3));
    }
}
