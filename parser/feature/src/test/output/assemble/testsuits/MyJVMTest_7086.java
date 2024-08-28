public class MyJVMTest_7086 {

    static double[] a = { 0.6052213672105795, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, 0d, Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    double sumb(double[] a) {
        Double result = 1.;
        for (Double i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7086().sumb(a));
    }
}
