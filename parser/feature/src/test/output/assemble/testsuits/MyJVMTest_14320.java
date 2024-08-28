public class MyJVMTest_14320 {

    static double[] a = { 0.8915722401560711, Double.NaN, 0d, Double.MIN_VALUE, 0d, 0d, Double.NaN, Double.NEGATIVE_INFINITY, 0.6839253150469917, Double.NaN };

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
        System.out.println(new MyJVMTest_14320().sum2(a));
    }
}
