public class MyJVMTest_6127 {

    static double[] src = { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.8845219123195501, Double.NEGATIVE_INFINITY, 0.7895117241583265, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double[] dst = { Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, 0d, Double.MIN_VALUE, Double.MIN_VALUE, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE };

    static boolean flag = false;

    boolean test_helper() {
        test_helper_i++;
        return (test_helper_i & 7) != 0;
    }

    static int test_helper_i = 1154308248;

    double[] test(double[] src, double[] dst, boolean flag) {
        double j = 0.0;
        while (test_helper()) {
            for (int i = 0; i < src.length; i++) {
                dst[i] = src[i] + j;
            }
            for (int i = 0; i < src.length; i++) {
                double k;
                if (flag) {
                    k = j;
                } else {
                    k = 0;
                }
                dst[i] = src[i] + k;
            }
            j++;
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6127().test(src, dst, flag);
    }
}
