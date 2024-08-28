public class MyJVMTest_12870 {

    static long[] a = { 0, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, 0, 9223372036854775807L, 0, 9223372036854775807L, 0 };

    static long[] b = { -9223372036854775808L, 0, 0, 8774648350389035529L, 0, 0, 0, 0, 9223372036854775807L, -9223372036854775808L };

    static double[] c = { 0.8925450662438436, Double.MAX_VALUE, 0d, Double.NEGATIVE_INFINITY, 0d, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MIN_VALUE };

    static double[] d = { Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    long[] test_cp_alnsrc(long[] a, long[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12870().test_cp_alnsrc(a, b, c, d);
    }
}
