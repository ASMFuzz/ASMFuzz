public class MyJVMTest_14978 {

    static int k = 1426474889, m = 3, n = -68026817;

    static float a = 0f, b = Float.MAX_VALUE, c = Float.NEGATIVE_INFINITY, d = Float.NaN, x = Float.NEGATIVE_INFINITY;

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
        System.out.println(new MyJVMTest_14978().eCheck());
    }
}
