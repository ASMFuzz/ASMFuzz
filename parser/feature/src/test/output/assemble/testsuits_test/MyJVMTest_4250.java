public class MyJVMTest_4250 {

    static int start = 0;

    static int stop = -1499918854;

    static double[] array1 = { 0d, Double.NEGATIVE_INFINITY, Double.NaN, Double.NaN, Double.MIN_VALUE, Double.NaN, 0d, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    static double[] array2 = { Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d };

    static int exit = 0;

    static int barrier = 1849743837;

    boolean test2_helper(int start, int stop, double[] array1, double[] array2, int exit) {
        for (int i = start - 1; i >= stop; i--) {
            array1[i] = array2[i];
            if (i == exit) {
                return true;
            }
            barrier = 0x42;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4250().test2_helper(start, stop, array1, array2, exit));
    }
}
