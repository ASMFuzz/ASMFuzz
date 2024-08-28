public class MyJVMTest_4918 {

    static double[] a = { 0d, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE };

    double sum2(double[] a) {
        double result1 = 1.;
        double result2 = 1.;
        for (Double i : a) {
            result1 += i;
            result2 += i + 1.;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4918().sum2(a));
    }
}
