public class MyJVMTest_10432 {

    static long[] a = { 4299114324680599940L, 2092909980724810921L, 9223372036854775807L, 0, -335460789483642428L, 6682307689779216903L, 9223372036854775807L, 0, -4913175033610739282L, -9223372036854775808L };

    static double[] b = { 0d, Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, Double.NaN, Double.NaN, 0d };

    static long c = -9223372036854775808L;

    static double d = Double.POSITIVE_INFINITY;

    long[] test_vi(long[] a, double[] b, long c, double d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10432().test_vi(a, b, c, d);
    }
}
