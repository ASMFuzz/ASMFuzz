public class MyJVMTest_17732 {

    static double[] arr = { Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, 0.26441313268058786, Double.MAX_VALUE, 0d, Double.NaN, 0.9092619230224631, Double.NEGATIVE_INFINITY, Double.NaN };

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
        new MyJVMTest_17732().initAr(arr);
    }
}
