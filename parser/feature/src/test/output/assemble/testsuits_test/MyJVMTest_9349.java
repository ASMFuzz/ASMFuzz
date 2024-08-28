public class MyJVMTest_9349 {

    static double[] a = { Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0d, 0d, 0d, Double.NaN, 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY };

    double sum(double[] a) {
        double result = 1.;
        for (Double i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9349().sum(a));
    }
}
