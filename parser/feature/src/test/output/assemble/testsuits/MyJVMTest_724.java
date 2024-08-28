public class MyJVMTest_724 {

    static double[] array1 = { Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, 0.49267628536686947, Double.MAX_VALUE, Double.MIN_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, 0.27721278494619794, Double.MAX_VALUE };

    static double[] array2 = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0d, Double.NaN, 0d, Double.MIN_VALUE, Double.NaN, Double.MIN_VALUE };

    double test(double[] array1, double[] array2) {
        double res = 0;
        for (int i = 0; i < array1.length; i++) {
            array2[i] = i;
            res += array1[i];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_724().test(array1, array2));
    }
}
