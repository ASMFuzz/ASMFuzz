public class MyJVMTest_5982 {

    static int k = 1949395040, m = 0, n = -1549613009;

    static float a = Float.POSITIVE_INFINITY, b = Float.MIN_VALUE, c = 0.07010037f, d = Float.MIN_VALUE, x = Float.MIN_VALUE;

    static float[] arr = new float[100];

    static float[] arr_opt = new float[100];

    static float[][] arr1 = new float[10][10];

    static float[][] arr1_opt = new float[10][10];

    void mat() {
        for (k = 1; k < 10; k++) {
            n = k * 10;
            for (m = 0; m < 10; m++) {
                arr[n + m] = (float) Math.exp((double) arr[m]);
                arr1[k][m] = (float) (arr[m] * 1 / Math.PI);
                arr_opt[n + m] = (float) Math.exp((double) arr_opt[m]);
                arr1_opt[k][m] = (float) (arr_opt[m] * 1 / Math.PI);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5982().mat();
    }
}
