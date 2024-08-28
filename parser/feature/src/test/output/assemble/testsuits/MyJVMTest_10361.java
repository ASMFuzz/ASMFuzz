public class MyJVMTest_10361 {

    static float[][] value = {{Float.NaN,0f,0.802881f,Float.NaN,0f,7.1525574E-5f,Float.NEGATIVE_INFINITY,Float.MIN_VALUE,Float.MAX_VALUE,0.53595597f},{Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.NaN,Float.NaN,Float.POSITIVE_INFINITY,Float.MIN_VALUE,Float.MAX_VALUE,0.14195669f,Float.NEGATIVE_INFINITY,Float.POSITIVE_INFINITY}};

    static boolean isConsistent = false;

    static float[][] result = {{Float.MIN_VALUE,Float.MAX_VALUE,0.15849477f,0f,0.7160298f,Float.NEGATIVE_INFINITY,0f,Float.POSITIVE_INFINITY,Float.MAX_VALUE,Float.NEGATIVE_INFINITY},{Float.MAX_VALUE,0.043114364f,Float.POSITIVE_INFINITY,Float.NaN,Float.MAX_VALUE,Float.MAX_VALUE,Float.MAX_VALUE,Float.NaN,Float.NEGATIVE_INFINITY,Float.NaN}};

    static float[][] source = {{0.08794761f,0.8567825f,0.8414982f,0f,Float.NaN,Float.NaN,Float.MAX_VALUE,Float.NEGATIVE_INFINITY,Float.MIN_VALUE,Float.POSITIVE_INFINITY},{Float.MIN_VALUE,Float.MAX_VALUE,0.084270954f,0f,Float.NaN,Float.MIN_VALUE,Float.NaN,Float.MIN_VALUE,Float.NaN,Float.MIN_VALUE}};

    static int line0 = 1;

    static int bunch = 5;

    static boolean threadExecuted = false;

    void run() {
        int line1 = line0 + bunch;
        int size = result.length;
        for (int line = line0; line < line1; line++) for (int column = 0; column < size; column++) {
            float sum = 0;
            for (int i = 0; i < size; i++) sum += source[line][i] * source[i][column];
            result[line][column] = sum;
        }
        threadExecuted = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10361().run();
    }
}
