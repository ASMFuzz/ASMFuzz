public class MyJVMTest_16605 {

    static double[] a = { Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0.9746909239341334, Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d };

    double sumb(double[] a) {
        Double result = 1.;
        for (Double i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16605().sumb(a));
    }
}
