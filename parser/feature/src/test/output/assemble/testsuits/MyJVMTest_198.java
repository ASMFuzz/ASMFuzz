public class MyJVMTest_198 {

    static double[] a = { Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, 0.692966538300153, Double.MAX_VALUE, 0d, Double.POSITIVE_INFINITY };

    double sum(double[] a) {
        double result = 1.;
        for (Double i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_198().sum(a));
    }
}
