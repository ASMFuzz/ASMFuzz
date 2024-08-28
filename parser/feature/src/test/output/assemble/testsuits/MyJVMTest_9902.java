public class MyJVMTest_9902 {

    static double[] array1 = { 0d, Double.MAX_VALUE, Double.NaN, Double.NaN, Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, 0.1706557439467512 };

    static double[] array2 = { Double.NaN, 0.8706158848261929, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.2099549864930591, Double.NaN, 0.2728420172681739, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY };

    double test(double[] array1, double[] array2) {
        double res = 0;
        for (int i = 0; i < array1.length; i++) {
            array2[i] = i;
            res += array1[i];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9902().test(array1, array2));
    }
}
