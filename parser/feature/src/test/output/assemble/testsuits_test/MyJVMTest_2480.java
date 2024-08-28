public class MyJVMTest_2480 {

    static float[][] value = {{0.06269592f,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,Float.MAX_VALUE,Float.MAX_VALUE,0f,Float.MIN_VALUE,Float.POSITIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.POSITIVE_INFINITY},{Float.MAX_VALUE,0f,Float.MIN_VALUE,Float.MAX_VALUE,Float.NEGATIVE_INFINITY,Float.NEGATIVE_INFINITY,Float.NaN,0.91492254f,0f,0f}};

    static float[][] result = {{0.69148123f,0.1025095f,0f,Float.MIN_VALUE,Float.NEGATIVE_INFINITY,0.45156252f,0f,Float.POSITIVE_INFINITY,9.176731E-4f,Float.POSITIVE_INFINITY},{0.95781916f,Float.MAX_VALUE,Float.MIN_VALUE,0f,0.5238664f,0.14593738f,0f,Float.NaN,Float.POSITIVE_INFINITY,Float.NaN}};

    static float[][] source = {{Float.NEGATIVE_INFINITY,Float.MAX_VALUE,0f,Float.POSITIVE_INFINITY,Float.MIN_VALUE,Float.MAX_VALUE,Float.MAX_VALUE,Float.MAX_VALUE,Float.POSITIVE_INFINITY,Float.MAX_VALUE},{0f,0.38388687f,0.71444386f,0.15335941f,0f,Float.NaN,Float.POSITIVE_INFINITY,Float.NEGATIVE_INFINITY,0f,0f}};

    static int line0 = 2;

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
        new MyJVMTest_2480().run();
    }
}
