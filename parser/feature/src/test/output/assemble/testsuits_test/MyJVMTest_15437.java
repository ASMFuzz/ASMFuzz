public class MyJVMTest_15437 {

    static int k = -1501579782, m = 0, n = 1;

    static float a = Float.NEGATIVE_INFINITY, b = 0f, c = Float.POSITIVE_INFINITY, d = Float.NaN, x = 0f;

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
        new MyJVMTest_15437().mat();
    }
}
