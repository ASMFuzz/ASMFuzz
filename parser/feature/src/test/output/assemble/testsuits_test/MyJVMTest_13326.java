public class MyJVMTest_13326 {

    static int start = 6;

    static int stop = 2;

    static double[] array1 = { Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d };

    static double[] array2 = { Double.MIN_VALUE, 0d, Double.NEGATIVE_INFINITY, 0d, 0.6458681208010136, 0.39248462487829816, 0d, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE };

    static int exit = 0;

    static int barrier = 2;

    boolean test3_helper(int start, int stop, double[] array1, double[] array2, int exit) {
        for (int i = start; i < stop; i++) {
            array1[stop - i - 1] = array2[stop - i - 1];
            if (i == exit) {
                return true;
            }
            barrier = 0x42;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13326().test3_helper(start, stop, array1, array2, exit));
    }
}
