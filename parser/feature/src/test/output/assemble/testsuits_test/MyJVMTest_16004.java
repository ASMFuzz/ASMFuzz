public class MyJVMTest_16004 {

    static double[] a = { Double.NEGATIVE_INFINITY, 0d, Double.MIN_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0.532627965318778, Double.MAX_VALUE, 0.4609876463399962, Double.NaN };

    static Double ibc = new Double(1.);

    double sumc2(double[] a) {
        Double result1 = 1.;
        Double result2 = ibc;
        for (Double i : a) {
            result1 += i;
            result2 += i + ibc;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16004().sumc2(a));
    }
}
