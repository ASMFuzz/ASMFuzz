public class MyJVMTest_8159 {

    static double[] arr = { Double.MIN_VALUE, Double.NaN, Double.MAX_VALUE, 0.409450318453331, 0.8400946313779127, 0.9351393111843819, Double.POSITIVE_INFINITY, 0.2667931541070525, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    static int LEN = 500;

    double initAr(double[] arr) {
        double r1, r2, r3;
        for (int r = 0; r < LEN; r++) {
            r1 = LEN / (r + 1);
            r2 = Math.sqrt(r1 * r1);
            r3 = Math.sin(r2);
            arr[r] = r2 / r3;
        }
        return r1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8159().initAr(arr);
    }
}
