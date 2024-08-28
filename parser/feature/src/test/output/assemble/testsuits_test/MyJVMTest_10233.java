public class MyJVMTest_10233 {

    static double[][] result = {{0.3967006562257238,0.06131950532519459,Double.NaN,Double.POSITIVE_INFINITY,Double.MAX_VALUE,Double.MAX_VALUE,Double.POSITIVE_INFINITY,Double.MAX_VALUE,Double.MIN_VALUE,Double.POSITIVE_INFINITY},{Double.POSITIVE_INFINITY,0d,Double.MIN_VALUE,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,0.4589395780463027,Double.MIN_VALUE,0d,Double.MAX_VALUE,Double.NEGATIVE_INFINITY}};

    static double[][] source = {{Double.POSITIVE_INFINITY,Double.MIN_VALUE,Double.NaN,Double.NaN,0.4788527303641338,Double.NaN,Double.NaN,Double.NEGATIVE_INFINITY,Double.NaN,Double.NaN},{0.03004045847828629,Double.NaN,0.540411714205178,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.MAX_VALUE,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY}};

    static int line0 = 0;

    static int bunch = 2;

    void run() {
        int line1 = line0 + bunch;
        int size = result.length;
        for (int line = line0; line < line1; line++) for (int column = 0; column < size; column++) {
            double sum = 0;
            for (int i = 0; i < size; i++) sum += source[line][i] * source[i][column];
            result[line][column] = sum;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10233().run();
    }
}
