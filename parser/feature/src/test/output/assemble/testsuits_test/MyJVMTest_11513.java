public class MyJVMTest_11513 {

    static int start = 2;

    static int stop = 0;

    static int from = 4;

    static double[] array1 = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.361591687318087, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, 0.9616875540519466 };

    static double[] array2 = { 0.4622151078761261, 0d, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NaN, 0.5469431077395421, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY };

    static int exit = 0;

    static int barrier = 1;

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
        System.out.println(new MyJVMTest_11513().test4_helper(start, stop, from, array1, array2, exit));
    }
}
