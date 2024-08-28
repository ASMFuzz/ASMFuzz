public class MyJVMTest_12639 {

    static float[][] result = {{Float.MAX_VALUE,Float.MIN_VALUE,Float.POSITIVE_INFINITY,0f,0f,Float.NEGATIVE_INFINITY,Float.MIN_VALUE,Float.NaN,Float.NaN,Float.MIN_VALUE},{0f,Float.NaN,Float.POSITIVE_INFINITY,0.055661857f,0f,0f,Float.MIN_VALUE,0.13039684f,Float.POSITIVE_INFINITY,Float.MIN_VALUE}};

    static float[][] source = {{Float.POSITIVE_INFINITY,0.7645621f,Float.NEGATIVE_INFINITY,Float.NaN,Float.NaN,Float.NEGATIVE_INFINITY,Float.POSITIVE_INFINITY,Float.NaN,Float.MAX_VALUE,Float.NEGATIVE_INFINITY},{0.6038307f,Float.MIN_VALUE,0.48897815f,0.38771278f,Float.NaN,Float.POSITIVE_INFINITY,0f,Float.NaN,0.099090934f,Float.NaN}};

    static int line0 = 8;

    static int bunch = 9;

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
        new MyJVMTest_12639().run();
    }
}
