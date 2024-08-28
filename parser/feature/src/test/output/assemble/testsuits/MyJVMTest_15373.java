public class MyJVMTest_15373 {

    static int k = -983831391, m = 1, n = 7;

    static double a = Double.POSITIVE_INFINITY, b = 0d, c = Double.MAX_VALUE, d = 0.21429329979897294;

    static double[] arr = new double[100];

    static double[] arr_opt = new double[100];

    static double[][] arr1 = new double[10][10];

    static double[][] arr1_opt = new double[10][10];

    boolean eCheck() {
        boolean st = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr_opt[i]) {
                System.out.println(">>Bad output: arr[" + i + "]=" + arr[i] + "; arr_opt[" + i + "]=" + arr_opt[i]);
                st = false;
            }
        }
        for (int i = 0; i < arr1.length; i++) for (int j = 0; j < arr1[i].length; j++) {
            if (arr1[i][j] != arr1_opt[i][j]) {
                System.out.println(">>Bad output: arr[" + i + "][" + j + "]=" + arr1[i][j] + "; arr_opt[" + i + "][" + j + "]=" + arr1_opt[i][j]);
                st = false;
            }
        }
        return st;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15373().eCheck());
    }
}
