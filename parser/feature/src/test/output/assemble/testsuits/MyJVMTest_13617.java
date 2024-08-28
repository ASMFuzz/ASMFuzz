public class MyJVMTest_13617 {

    static int start = 0;

    static int stop = 0;

    static double[] array1 = { 0d, Double.NaN, Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY };

    static double[] array2 = { 0d, 0.8305306248826549, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NaN, Double.NaN, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0d };

    static int exit = 1924128434;

    static int barrier = 0;

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
        System.out.println(new MyJVMTest_13617().test2_helper(start, stop, array1, array2, exit));
    }
}
