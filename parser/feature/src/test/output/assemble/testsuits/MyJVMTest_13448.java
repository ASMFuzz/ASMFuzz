public class MyJVMTest_13448 {

    static int k = 5, m = 9, n = -511047416;

    static double a = 0.4311854148011426, b = 0d, c = 0d, d = Double.NEGATIVE_INFINITY;

    static double[] arr = new double[100];

    static double[] arr_opt = new double[100];

    static double[][] arr1 = new double[10][10];

    static double[][] arr1_opt = new double[10][10];

    void mat() {
        for (k = 0; k < arr1[0].length; k++) {
            n = k * arr1[0].length;
            for (m = 0; m < arr1[0].length; m++) {
                arr[n + m] = Math.exp(arr[m]);
                arr_opt[n + m] = Math.exp(arr_opt[m]);
                arr1[k][m] = (arr[m] * 1 / Math.PI);
                arr1_opt[k][m] = (arr_opt[m] * 1 / Math.PI);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13448().mat();
    }
}
