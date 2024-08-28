public class MyJVMTest_16886 {

    static double[] a = { 0d, Double.NEGATIVE_INFINITY, 0.6570870026628788, Double.NaN, 0d, 0.47746690782847534, Double.MAX_VALUE, Double.NaN, 0.8486455810901401, 0.6397481465788981 };

    static double[] b = { Double.NaN, 0.40135962619330223, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN, 0.7871531198858723, 0.8749710448361954, 0.6669874268408698, Double.MIN_VALUE, Double.POSITIVE_INFINITY };

    static double[] c = { Double.NaN, Double.POSITIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.45812701830794544, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY };

    static double[] d = { 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, 0d, 0.8366730299068637, Double.NaN, Double.MIN_VALUE, Double.NaN, 0.2665931957974831 };

    static double total = 0.6470220570800522;

    double sumReductionImplement(double[] a, double[] b, double[] c, double[] d, double total) {
        for (int i = 0; i < a.length; i++) {
            d[i] = Math.abs(-a[i] * -b[i]) + Math.abs(-a[i] * -c[i]) + Math.abs(-b[i] * -c[i]);
            total += d[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16886().sumReductionImplement(a, b, c, d, total));
    }
}
