public class MyJVMTest_1738 {

    static int start = 2078601878;

    static int stop = 8;

    static double[] array1 = { Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0d, 0d, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, 0d };

    static double[] array2 = { 0.9991165659286573, 0.4434876879980266, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, 0.7798308731063506, Double.NaN, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE };

    static int exit = 8;

    static int barrier = 0;

    boolean test1_helper(int start, int stop, double[] array1, double[] array2, int exit) {
        for (int i = start; i < stop; i++) {
            array1[i] = array2[i];
            if (i == exit) {
                return true;
            }
            barrier = 0x42;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1738().test1_helper(start, stop, array1, array2, exit));
    }
}
