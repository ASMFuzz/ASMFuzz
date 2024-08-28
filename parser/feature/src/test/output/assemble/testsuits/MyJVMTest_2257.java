public class MyJVMTest_2257 {

    static int start = 0;

    static int stop = -1473129933;

    static int from = 1385857881;

    static double[] array1 = { 0d, 0.8808580478981165, 0.7568561812877793, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.POSITIVE_INFINITY };

    static double[] array2 = { Double.NaN, 0.7150413111941887, 0.4237950380354988, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, Double.NaN, 0.7784438985047122 };

    static int exit = 5;

    static int barrier = 8;

    boolean test4_helper(int start, int stop, int from, double[] array1, double[] array2, int exit) {
        for (int i = start - 1; i >= stop; i--) {
            array1[from - i - 1] = array2[from - i - 1];
            if (i == exit) {
                return true;
            }
            barrier = 0x42;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2257().test4_helper(start, stop, from, array1, array2, exit));
    }
}
