public class MyJVMTest_17672 {

    static double[][] value = {{0d,Double.NaN,0.39598330389058634,Double.MIN_VALUE,Double.NaN,Double.NaN,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY},{Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.NaN,0d,Double.NEGATIVE_INFINITY,Double.MAX_VALUE,Double.NEGATIVE_INFINITY,0d,Double.MIN_VALUE}};

    static double[][] result = {{Double.MAX_VALUE,0d,Double.NEGATIVE_INFINITY,0d,0d,Double.NaN,0d,0d,0d,Double.NaN},{Double.MAX_VALUE,Double.POSITIVE_INFINITY,Double.MAX_VALUE,Double.MAX_VALUE,Double.NaN,Double.MIN_VALUE,0d,0d,0.30939383218190064,0d}};

    static double[][] source = {{Double.POSITIVE_INFINITY,Double.MAX_VALUE,Double.MAX_VALUE,Double.MIN_VALUE,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,0.8524199569938596,Double.NEGATIVE_INFINITY,Double.MAX_VALUE,Double.NaN},{Double.POSITIVE_INFINITY,Double.MIN_VALUE,Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY,0d,Double.NEGATIVE_INFINITY,Double.MIN_VALUE,Double.MIN_VALUE,Double.MIN_VALUE,Double.NEGATIVE_INFINITY}};

    static int line0 = -1082261376;

    static int bunch = 9;

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
        new MyJVMTest_17672().run();
    }
}
