public class MyJVMTest_3088 {

    static long[] a = { -9223372036854775808L, 3442241107335311997L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, -9223372036854775808L, 0, 0, -9223372036854775808L };

    static long[] b = { -9223372036854775808L, 9223372036854775807L, 8797342548350000005L, 0, -6021948654354136841L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 2836593437726670598L };

    static double[] c = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN, 0d, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0.09724284396110305 };

    static double[] d = { 0.6666383079276329, Double.MAX_VALUE, Double.MIN_VALUE, 0.04813167852294664, Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE, 0d, Double.NaN, Double.NEGATIVE_INFINITY };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_cp_unalnsrc(long[] a, long[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3088().test_cp_unalnsrc(a, b, c, d);
    }
}
