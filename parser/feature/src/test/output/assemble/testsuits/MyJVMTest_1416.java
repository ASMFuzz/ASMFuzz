public class MyJVMTest_1416 {

    static long[] a = { -280030793054795120L, 9223372036854775807L, -9223372036854775808L, 2148173963860147855L, -9223372036854775808L, -8947109406078680501L, -6995893416450585937L, -9223372036854775808L, 0, 426121258647029806L };

    static double[] b = { Double.MIN_VALUE, 0.20549845007083822, Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, 0d };

    long[] test_ci_oppos(long[] a, double[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = -123;
            b[i] = -103.;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1416().test_ci_oppos(a, b);
    }
}
