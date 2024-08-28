public class MyJVMTest_10961 {

    static int start = 316652219;

    static int stop = 0;

    static double[] array1 = { Double.MAX_VALUE, 0.3448806553954292, 0d, Double.NEGATIVE_INFINITY, Double.NaN, Double.MIN_VALUE, 0.6786849796560412, 0d, Double.POSITIVE_INFINITY, Double.MIN_VALUE };

    static double[] array2 = { Double.POSITIVE_INFINITY, Double.MIN_VALUE, 0d, Double.NaN, Double.NEGATIVE_INFINITY, 0.7623674483791281, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE };

    static int exit = 1224073466;

    static int barrier = 6;

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
        System.out.println(new MyJVMTest_10961().test1_helper(start, stop, array1, array2, exit));
    }
}
