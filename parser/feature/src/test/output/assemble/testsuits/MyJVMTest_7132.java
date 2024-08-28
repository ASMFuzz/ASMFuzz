public class MyJVMTest_7132 {

    static long[] a = { 1996726793249877653L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0, -7608942395978453157L, 9223372036854775807L, 0, -1815016908404417766L, 0 };

    static long[] b = { -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -6494869891614209282L, -1348758942924533622L, 9223372036854775807L, 0, 368409528603535387L, 9223372036854775807L };

    static double[] c = { Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.MIN_VALUE, 0.977784124826232, Double.MIN_VALUE, Double.NaN, Double.NaN };

    static double[] d = { 0.5534820685161574, Double.MIN_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.NaN, Double.MAX_VALUE, Double.NaN, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    long[] test_cp_unalndst(long[] a, long[] b, double[] c, double[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7132().test_cp_unalndst(a, b, c, d);
    }
}
