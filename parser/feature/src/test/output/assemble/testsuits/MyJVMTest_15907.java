public class MyJVMTest_15907 {

    static int[] a = { -1276844778, 7, -201070171, -579161516, 0, 0, 0, 451940391, 8, -679871154 };

    static int[] b = { -140939374, 0, 4, 0, 1, 4, 9, 1, 1547674644, 0 };

    static double[] c = { Double.MIN_VALUE, 0.5740244750147273, 0d, Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, 0.4168169792830997, Double.MIN_VALUE, Double.MAX_VALUE, 0d };

    static double[] d = { Double.NaN, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY };

    int[] test_cp_oppos(int[] a, int[] b, double[] c, double[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15907().test_cp_oppos(a, b, c, d);
    }
}
