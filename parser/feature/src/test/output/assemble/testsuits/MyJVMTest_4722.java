public class MyJVMTest_4722 {

    static double[] data = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN };

    static double A = Double.POSITIVE_INFINITY;

    static double B = 0.9327624497522197;

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
        new MyJVMTest_4722().test(data, A, B);
    }
}
