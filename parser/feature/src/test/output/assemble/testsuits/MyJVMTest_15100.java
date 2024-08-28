public class MyJVMTest_15100 {

    static double[] a = { 0d, 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, 0.8566742492649277, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE };

    static Double ibc = new Double(1.);

    double sumc(double[] a) {
        Double result = ibc;
        for (Double i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15100().sumc(a));
    }
}
