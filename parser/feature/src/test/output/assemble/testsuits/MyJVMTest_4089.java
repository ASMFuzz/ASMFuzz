public class MyJVMTest_4089 {

    static int k = -312290224, m = 1248765753, n = 1042017029;

    static double a = Double.POSITIVE_INFINITY, b = Double.NaN, c = 0.3427515137822478, d = Double.MAX_VALUE;

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
        new MyJVMTest_4089().mat();
    }
}
