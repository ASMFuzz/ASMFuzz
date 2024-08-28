public class MyJVMTest_1232 {

    static long[] a = { 9223372036854775807L, -3177817619987318251L, 0, 9223372036854775807L, 0, 0, 7750490536525633746L, 9223372036854775807L, -9223372036854775808L, -1126856218217823080L };

    static double[] b = { Double.MIN_VALUE, 0d, 0.48831368065096736, Double.MAX_VALUE, 0d, Double.NaN, Double.MAX_VALUE, 0.8416916052326603, Double.NaN, Double.NEGATIVE_INFINITY };

    static long c = 9223372036854775807L;

    static double d = 0d;

    long[] test_vi(long[] a, double[] b, long c, double d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1232().test_vi(a, b, c, d);
    }
}
