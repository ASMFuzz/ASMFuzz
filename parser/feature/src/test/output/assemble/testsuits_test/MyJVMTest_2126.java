public class MyJVMTest_2126 {

    static int[] a1 = { 1, -445316350, 5, 2, 8, 0, 4, 0, 3, 0 };

    static int[] a2 = { 7, 3, 0, 6, 4, 7, 1, 1944196917, 0, 3 };

    static int[] a3 = { 0, 3, 1, 0, 7, 8, -355412581, 262847825, 0, 2 };

    static long[] b1 = { -9223372036854775808L, -6318400288288090132L, -9223372036854775808L, -2938222819515961495L, -6508746829625894079L, 0, -8530285851503658076L, -9223372036854775808L, -5931453683370806117L, -522797763644805054L };

    static long[] b2 = { -7834013065874829767L, 0, 8128806949540027257L, 0, 0, -9223372036854775808L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 0 };

    static long[] b3 = { -9223372036854775808L, 9223372036854775807L, -8316186002631303208L, 9223372036854775807L, 9223372036854775807L, 0, -9223372036854775808L, 5141393292218101897L, 9223372036854775807L, 9223372036854775807L };

    static float[] c1 = { 0.7748657f, Float.NaN, Float.MAX_VALUE, Float.POSITIVE_INFINITY, Float.MAX_VALUE, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0f, 0f };

    static float[] c2 = { 0f, 0.31171113f, Float.NEGATIVE_INFINITY, 0.8495396f, 0.7332552f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.NEGATIVE_INFINITY };

    static float[] c3 = { Float.NaN, Float.NEGATIVE_INFINITY, 0.6965543f, Float.NaN, 0.27170038f, Float.NaN, Float.POSITIVE_INFINITY, 0.023712277f, Float.NEGATIVE_INFINITY, Float.MAX_VALUE };

    static double[] d1 = { Double.NEGATIVE_INFINITY, 0.4484002385477096, Double.MIN_VALUE, 0.18529590959689246, Double.POSITIVE_INFINITY, 0d, Double.NEGATIVE_INFINITY, 0.29514909185350857, Double.MIN_VALUE, Double.NaN };

    static double[] d2 = { 0d, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.7788372193268772, 0.3161604302142592, Double.NEGATIVE_INFINITY, 0.709656546414439, Double.MIN_VALUE, 0.6427682145569095, Double.NEGATIVE_INFINITY };

    static double[] d3 = { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.23739231607159073, Double.MAX_VALUE, Double.NaN, Double.NEGATIVE_INFINITY, 0.23171595965319347, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.MAX_VALUE };

    int[] ReductionInit(int[] a1, int[] a2, int[] a3, long[] b1, long[] b2, long[] b3, float[] c1, float[] c2, float[] c3, double[] d1, double[] d2, double[] d3) {
        for (int i = 0; i < a1.length; i++) {
            a1[i] = (i + 0);
            a2[i] = (i + 1);
            a3[i] = (i + 2);
            b1[i] = (long) (i + 0);
            b2[i] = (long) (i + 1);
            b3[i] = (long) (i + 2);
            c1[i] = (float) (i + 0);
            c2[i] = (float) (i + 1);
            c3[i] = (float) (i + 2);
            d1[i] = (double) (i + 0);
            d2[i] = (double) (i + 1);
            d3[i] = (double) (i + 2);
        }
        return a1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2126().ReductionInit(a1, a2, a3, b1, b2, b3, c1, c2, c3, d1, d2, d3);
    }
}
