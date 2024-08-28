public class MyJVMTest_11749 {

    static float[][] value = {{Float.MIN_VALUE,Float.NEGATIVE_INFINITY,Float.POSITIVE_INFINITY,0.8927603f,0.21673304f,0f,Float.NaN,Float.POSITIVE_INFINITY,Float.MIN_VALUE,Float.MAX_VALUE},{Float.MAX_VALUE,0f,Float.NEGATIVE_INFINITY,Float.MAX_VALUE,Float.MAX_VALUE,Float.NEGATIVE_INFINITY,Float.MAX_VALUE,0f,0.63590705f,Float.NEGATIVE_INFINITY}};

    static float[][] result = {{Float.MIN_VALUE,Float.MIN_VALUE,Float.MIN_VALUE,Float.POSITIVE_INFINITY,Float.MIN_VALUE,Float.MIN_VALUE,Float.MIN_VALUE,0f,Float.MIN_VALUE,0f},{Float.NaN,Float.MIN_VALUE,Float.NaN,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,0.8220784f,Float.NEGATIVE_INFINITY,Float.NaN,Float.MIN_VALUE,Float.POSITIVE_INFINITY}};

    static float[][] source = {{Float.NEGATIVE_INFINITY,Float.NaN,Float.MIN_VALUE,0.8229851f,0.3185616f,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,0f,Float.MIN_VALUE},{Float.NaN,Float.NEGATIVE_INFINITY,Float.MAX_VALUE,0f,0.33853483f,Float.POSITIVE_INFINITY,0.5774503f,Float.MIN_VALUE,Float.NaN,0.8300089f}};

    static int line0 = 0;

    static int bunch = 2;

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
        new MyJVMTest_11749().run();
    }
}
