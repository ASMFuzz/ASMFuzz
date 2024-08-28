public class MyJVMTest_3536 {

    static long[] a = { 0, -9223372036854775808L, 4884621623279082317L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, 2239490737704087445L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L };

    static long[] b = { 9223372036854775807L, -9223372036854775808L, 0, 7734105884509703951L, 0, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, 4086393350964665511L };

    static double[] c = { 0.7602029405082489, Double.POSITIVE_INFINITY, 0d, 0d, Double.NaN, 0.18884123671057373, Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY };

    static double[] d = { Double.MIN_VALUE, 0.9260450951632188, Double.NaN, Double.NaN, 0.5177947735210146, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY };

    static int ALIGN_OFF = 8;

    long[] test_cp_alnsrc(long[] a, long[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3536().test_cp_alnsrc(a, b, c, d);
    }
}
