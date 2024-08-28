public class MyJVMTest_2616 {

    static double[] a = { Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, 0.8323782984773901, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, 0d };

    double checkSum(double[] a) {
        double sum = 0;
        for (int j = 0; j < a.length; j++) {
            sum += (a[j] / (j + 1) + a[j] % (j + 1));
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2616().checkSum(a));
    }
}
