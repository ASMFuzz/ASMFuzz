public class MyJVMTest_3551 {

    static double[] a = { Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY };

    static Double result2 = Double.POSITIVE_INFINITY;

    double sump2(double[] a, Double result2) {
        Double result1 = 1.;
        for (Double i : a) {
            result1 += i;
            result2 += i + 1.;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3551().sump2(a, result2));
    }
}
