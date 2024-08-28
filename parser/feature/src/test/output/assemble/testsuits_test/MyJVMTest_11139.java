public class MyJVMTest_11139 {

    static long[] a = { -3232281054538778709L, 9223372036854775807L, 0, 9223372036854775807L, 0, -9223372036854775808L, 9223372036854775807L, 1958900101816827231L, 0, 3690399247947735638L };

    static long[] b = { 0, 0, 6304776318207966318L, 6260760429581363016L, 0, 2822733920142271566L, 9223372036854775807L, 0, 8424742222971217629L, 0 };

    static float[] c = { Float.NaN, Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, 0.6111795f, Float.MIN_VALUE, Float.NEGATIVE_INFINITY, 0.63974744f, Float.MAX_VALUE, Float.NaN };

    static float[] d = { Float.MIN_VALUE, 0f, Float.MAX_VALUE, 0.61674875f, Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, Float.POSITIVE_INFINITY, 0.16303074f, Float.NEGATIVE_INFINITY };

    long[] test_cp_oppos(long[] a, long[] b, float[] c, float[] d) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
            c[limit - i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11139().test_cp_oppos(a, b, c, d);
    }
}
