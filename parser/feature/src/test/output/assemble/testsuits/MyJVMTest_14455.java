public class MyJVMTest_14455 {

    static double[] a = { 0.8804138138723467, 0.34192533749512544, 0d, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0.473702006876895 };

    static double b = Double.NaN;

    int test_vi_oppos(double[] a, double b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14455().test_vi_oppos(a, b);
    }
}
