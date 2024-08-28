public class MyJVMTest_1041 {

    static double[][] result = {{Double.NEGATIVE_INFINITY,0.714648579806683,Double.MAX_VALUE,0d,0d,Double.MIN_VALUE,0d,Double.NEGATIVE_INFINITY,Double.MAX_VALUE,0d},{Double.MIN_VALUE,Double.NaN,Double.MIN_VALUE,Double.MIN_VALUE,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.MAX_VALUE,Double.MAX_VALUE,Double.NaN,Double.NEGATIVE_INFINITY}};

    static double[][] source = {{Double.NaN,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,0.34414689778371554,0.7216210916670983,Double.MIN_VALUE,0d,Double.MAX_VALUE,Double.MIN_VALUE},{0.22364825461583482,Double.POSITIVE_INFINITY,Double.NaN,Double.MAX_VALUE,Double.NEGATIVE_INFINITY,0.24991742605499145,Double.MIN_VALUE,Double.NEGATIVE_INFINITY,Double.NaN,Double.MIN_VALUE}};

    static int line0 = 0;

    static int bunch = 4;

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
        new MyJVMTest_1041().run();
    }
}
