public class MyJVMTest_11897 {

    static double[] a = { Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY };

    double checkSum(double[] a) {
        double sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += (a[j] / (j + 1) + a[j] % (j + 1));
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11897().checkSum(a));
    }
}
