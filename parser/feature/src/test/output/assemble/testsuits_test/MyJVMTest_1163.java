public class MyJVMTest_1163 {

    static float[][] value = {{0f,Float.MIN_VALUE,Float.NaN,Float.MIN_VALUE,Float.NaN,Float.NaN,Float.MIN_VALUE,Float.MIN_VALUE,Float.NaN,Float.NaN},{Float.NaN,0f,Float.NEGATIVE_INFINITY,0f,Float.NaN,Float.POSITIVE_INFINITY,0f,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,Float.NaN}};

    static boolean isConsistent = false;

    static float[][] result = {{Float.NEGATIVE_INFINITY,0.40144902f,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,Float.MIN_VALUE,0f,Float.MAX_VALUE,Float.MIN_VALUE},{Float.MAX_VALUE,Float.NaN,Float.MIN_VALUE,Float.MIN_VALUE,0f,Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,Float.NaN,0.34526455f,Float.NEGATIVE_INFINITY}};

    static float[][] source = {{Float.MIN_VALUE,Float.POSITIVE_INFINITY,Float.MAX_VALUE,Float.MAX_VALUE,0.48022288f,Float.NaN,Float.POSITIVE_INFINITY,Float.MAX_VALUE,Float.MAX_VALUE,Float.POSITIVE_INFINITY},{Float.POSITIVE_INFINITY,Float.MIN_VALUE,0f,Float.POSITIVE_INFINITY,Float.MIN_VALUE,Float.POSITIVE_INFINITY,Float.NaN,0f,Float.MAX_VALUE,Float.MIN_VALUE}};

    static int line0 = 0;

    static int bunch = 0;

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
        new MyJVMTest_1163().run();
    }
}
