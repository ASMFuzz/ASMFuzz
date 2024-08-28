public class MyJVMTest_4975 {

    static long[] a = { -9223372036854775808L, 9223372036854775807L, -7519486020990007001L, 9223372036854775807L, -6707757152411915515L, 9223372036854775807L, 0, -9223372036854775808L, 0, 5129988508216449986L };

    static long[] b = { 9223372036854775807L, 9223372036854775807L, 1675612403822429897L, -9223372036854775808L, 0, 9223372036854775807L, 9223372036854775807L, -1995899754572438927L, -9223372036854775808L, -3730857240589285345L };

    static double[] c = { 0.23159428689612716, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, 0.8442257777400396, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, 0d, Double.NaN, 0d };

    static double[] d = { Double.NaN, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0.5858625117219053, Double.NaN, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.MAX_VALUE, 0.2215062830538611 };

    static int ALIGN_OFF = 8;

    long[] test_cp_alndst(long[] a, long[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4975().test_cp_alndst(a, b, c, d);
    }
}
