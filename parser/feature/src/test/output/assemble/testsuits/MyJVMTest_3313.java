public class MyJVMTest_3313 {

    static float[][] result = {{0f,Float.MAX_VALUE,0.42115742f,Float.MAX_VALUE,Float.POSITIVE_INFINITY,Float.POSITIVE_INFINITY,Float.MIN_VALUE,Float.NaN,Float.NEGATIVE_INFINITY,0f},{0f,Float.MAX_VALUE,Float.NaN,Float.NEGATIVE_INFINITY,Float.MIN_VALUE,Float.MAX_VALUE,Float.NaN,0.68563485f,0.99266976f,0f}};

    static float[][] source = {{Float.MIN_VALUE,0.66065794f,Float.NaN,Float.MIN_VALUE,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,0f,Float.NaN,0.73560846f,Float.NaN},{Float.MAX_VALUE,Float.NEGATIVE_INFINITY,0.9674191f,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,0.8302959f,Float.MIN_VALUE,0.105385125f,0f,Float.NEGATIVE_INFINITY}};

    static int line0 = -1820593907;

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
        new MyJVMTest_3313().run();
    }
}
