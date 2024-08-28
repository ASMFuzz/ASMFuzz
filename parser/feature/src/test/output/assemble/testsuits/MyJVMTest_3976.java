public class MyJVMTest_3976 {

    static int start = 0;

    static int stop = 4;

    static double[] array1 = { Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, 0.5332116166023076, 0.1830465791039524, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY };

    static double[] array2 = { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN, 0.8184838169062849, 0.9858247962166362, 0.743692303038989, 0d, 0d };

    static int exit = 0;

    static int barrier = 804127917;

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
        System.out.println(new MyJVMTest_3976().test3_helper(start, stop, array1, array2, exit));
    }
}
