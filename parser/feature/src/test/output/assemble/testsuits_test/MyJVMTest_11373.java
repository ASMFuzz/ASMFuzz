public class MyJVMTest_11373 {

    static int[] a1 = { -973430008, 0, 0, 1398289178, 0, -1726013830, -795919123, 1003211169, 0, 9 };

    static int[] a2 = { 0, 0, 0, 3, 0, 0, 0, 0, 0, 1 };

    static int[] a3 = { 1977582517, 2, 7, 1916914536, 4, 9, 0, 4, 7, 8 };

    static long[] b1 = { 0, 4119104371430720246L, -3525695643626284405L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0, -9223372036854775808L, 0, 7592674739449690928L };

    static long[] b2 = { -4436784566080830483L, -8485645930859377335L, 0, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    static long[] b3 = { 0, 9118027294237378499L, 8211147692631049987L, 0, -9223372036854775808L, 4883185974153505722L, -9223372036854775808L, 2203973914171366481L, 9223372036854775807L, -9223372036854775808L };

    static float[] c1 = { Float.MIN_VALUE, Float.MAX_VALUE, 0.32013768f, Float.MIN_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, 0f, Float.MIN_VALUE, 0f, Float.POSITIVE_INFINITY };

    static float[] c2 = { 0f, 0f, 0.17710763f, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, 0.28796262f, Float.MAX_VALUE, Float.NEGATIVE_INFINITY, 0.93771416f, Float.MAX_VALUE };

    static float[] c3 = { Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, 0.14500219f, Float.MAX_VALUE, Float.MIN_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0f };

    static double[] d1 = { Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0.3024373613275738, Double.MIN_VALUE, 0.3300498428151628, 0d, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0d };

    static double[] d2 = { Double.MIN_VALUE, 0d, Double.MAX_VALUE, 0.2354855711005993, 0d, Double.MAX_VALUE, 0.6711466321846427, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE };

    static double[] d3 = { Double.MAX_VALUE, Double.MIN_VALUE, 0d, Double.NaN, Double.NEGATIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.NaN, Double.POSITIVE_INFINITY };

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
        new MyJVMTest_11373().ReductionInit(a1, a2, a3, b1, b2, b3, c1, c2, c3, d1, d2, d3);
    }
}
