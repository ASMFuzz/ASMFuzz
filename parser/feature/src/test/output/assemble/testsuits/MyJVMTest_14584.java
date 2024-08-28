public class MyJVMTest_14584 {

    static float[][] result = {{0f,0f,0f,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.MAX_VALUE,Float.POSITIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.MIN_VALUE},{Float.NEGATIVE_INFINITY,Float.MAX_VALUE,0f,Float.NEGATIVE_INFINITY,0.8234905f,Float.POSITIVE_INFINITY,0f,Float.MAX_VALUE,Float.MAX_VALUE,Float.MIN_VALUE}};

    static float[][] source = {{Float.NaN,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,0.28785706f,Float.MIN_VALUE,0.54628557f,Float.NEGATIVE_INFINITY,Float.NaN,0f,Float.MAX_VALUE},{Float.NEGATIVE_INFINITY,Float.MAX_VALUE,Float.MIN_VALUE,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,0f,0f,Float.MIN_VALUE,Float.POSITIVE_INFINITY}};

    static int line0 = 0;

    static int bunch = 0;

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
        new MyJVMTest_14584().run();
    }
}
