public class MyJVMTest_15594 {

    static double[] src = { Double.MAX_VALUE, 0.20049264987833992, 0.0780745769029727, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE };

    static double[] dst = { Double.NaN, 0d, Double.MAX_VALUE, 0d, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.MIN_VALUE, Double.POSITIVE_INFINITY };

    static boolean flag = false;

    boolean test_helper() {
        test_helper_i++;
        return (test_helper_i & 7) != 0;
    }

    static int test_helper_i = 8;

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
        new MyJVMTest_15594().test(src, dst, flag);
    }
}
