public class MyJVMTest_8102 {

    static double[][] value = {{Double.MAX_VALUE,Double.MAX_VALUE,Double.NaN,Double.MIN_VALUE,0d,Double.MIN_VALUE,Double.NaN,0.010527676556685961,Double.POSITIVE_INFINITY,0.8531815006404574},{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.MIN_VALUE,Double.POSITIVE_INFINITY,0.643980131267811,Double.MAX_VALUE,Double.POSITIVE_INFINITY,Double.NaN,Double.POSITIVE_INFINITY}};

    static double[][] result = {{0d,Double.MIN_VALUE,Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE,0.399763613556826,Double.NEGATIVE_INFINITY,0.19904323148401082,Double.MAX_VALUE,Double.MAX_VALUE},{0d,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.NaN,Double.NEGATIVE_INFINITY,0d,Double.MIN_VALUE,Double.MIN_VALUE,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY}};

    static double[][] source = {{Double.MIN_VALUE,Double.MIN_VALUE,Double.NaN,0.8604920516200326,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,0d,Double.POSITIVE_INFINITY,Double.MIN_VALUE,0d},{Double.MAX_VALUE,Double.POSITIVE_INFINITY,0.07105310893412464,Double.MIN_VALUE,0d,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,0.8460329070904556,Double.NaN}};

    static int line0 = 1192519900;

    static int bunch = 0;

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
        new MyJVMTest_8102().run();
    }
}
