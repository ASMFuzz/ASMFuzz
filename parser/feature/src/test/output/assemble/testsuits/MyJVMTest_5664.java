public class MyJVMTest_5664 {

    static double[] a = { Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.MIN_VALUE, 0.1233482634502383, Double.NEGATIVE_INFINITY, 0.8596701661017471, Double.NEGATIVE_INFINITY, Double.NaN };

    static Double ibc = new Double(1.);

    double sumc(double[] a) {
        Double result = ibc;
        for (Double i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5664().sumc(a));
    }
}
