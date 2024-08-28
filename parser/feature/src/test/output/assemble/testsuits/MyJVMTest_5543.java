public class MyJVMTest_5543 {

    static int k = 5, m = 0, n = 428625449;

    static float a = Float.POSITIVE_INFINITY, b = Float.MIN_VALUE, c = Float.NEGATIVE_INFINITY, d = Float.MIN_VALUE, x = 0.120189965f;

    static float[] arr = new float[100];

    static float[] arr_opt = new float[100];

    static float[][] arr1 = new float[10][10];

    static float[][] arr1_opt = new float[10][10];

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
        System.out.println(new MyJVMTest_5543().eCheck());
    }
}
