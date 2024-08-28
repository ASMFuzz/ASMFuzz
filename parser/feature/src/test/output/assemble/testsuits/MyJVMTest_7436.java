public class MyJVMTest_7436 {

    static long[] a = { -9223372036854775808L, -6513440931000934659L, 9223372036854775807L, 3688819343671085432L, 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L, -9223372036854775808L, 0 };

    static long[] b = { -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 264001157820592126L, -9223372036854775808L, -251581219036152371L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    static double[] c = { Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0d, Double.MIN_VALUE, Double.NaN, 0d, 0d, Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE };

    static double[] d = { 0.06897193108583832, Double.MAX_VALUE, 0d, Double.MAX_VALUE, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, Double.MAX_VALUE, Double.NaN, Double.NaN, Double.POSITIVE_INFINITY };

    long[] test_cp_neg(long[] a, long[] b, double[] c, double[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7436().test_cp_neg(a, b, c, d);
    }
}
