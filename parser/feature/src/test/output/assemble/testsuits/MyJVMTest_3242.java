public class MyJVMTest_3242 {

    static double[] a = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0.2637088524897805 };

    double sumb2(double[] a) {
        Double result1 = 1.;
        Double result2 = 1.;
        for (Double i : a) {
            result1 += i;
            result2 += i + 1.;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3242().sumb2(a));
    }
}
