public class MyJVMTest_5168 {

    static float[][] result = {{Float.MIN_VALUE,Float.NaN,Float.MAX_VALUE,Float.NaN,Float.MIN_VALUE,Float.NaN,Float.POSITIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.NaN},{Float.NEGATIVE_INFINITY,0.85096097f,Float.MIN_VALUE,0.15837014f,Float.MAX_VALUE,0.98510534f,Float.MAX_VALUE,Float.MAX_VALUE,Float.POSITIVE_INFINITY,0.67983377f}};

    static float[][] source = {{Float.MAX_VALUE,0.6889508f,Float.MAX_VALUE,Float.NaN,0.5862761f,0f,Float.NaN,0f,Float.NEGATIVE_INFINITY,Float.NaN},{0f,0.28590286f,Float.MIN_VALUE,Float.NaN,0.9378971f,Float.NaN,0f,Float.NaN,Float.MIN_VALUE,Float.MIN_VALUE}};

    static int line0 = -1136364775;

    static int bunch = 144902317;

    void run() {
        int line1 = line0 + bunch;
        int size = result.length;
        for (int line = line0; line < line1; line++) for (int column = 0; column < size; column++) {
            float sum = 0;
            for (int i = 0; i < size; i++) sum += source[line][i] * source[i][column];
            result[line][column] = sum;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5168().run();
    }
}
