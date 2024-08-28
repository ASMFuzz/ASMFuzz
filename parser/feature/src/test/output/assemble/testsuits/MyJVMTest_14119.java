public class MyJVMTest_14119 {

    static double[] data = { Double.MIN_VALUE, 0d, Double.MIN_VALUE, Double.NaN, Double.NaN, Double.NaN, 0d, 0.20046009511091167, Double.NaN, 0d };

    static double A = Double.NEGATIVE_INFINITY;

    static double B = Double.MIN_VALUE;

    static int RANGE = 512;

    double[] test(double[] data, double A, double B) {
        for (int i = RANGE - 1; i > 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                data[j] = A * data[j + 1] + B * data[j];
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14119().test(data, A, B);
    }
}
