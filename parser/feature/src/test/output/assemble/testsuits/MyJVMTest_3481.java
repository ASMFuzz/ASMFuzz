public class MyJVMTest_3481 {

    static long[] a = { -1040271505850076785L, -9223372036854775808L, 9223372036854775807L, 4264938981103189645L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0, -9223372036854775808L, 0 };

    static long[] b = { 0, 9223372036854775807L, 9223372036854775807L, 0, 0, 9223372036854775807L, -6833169531041487161L, 5747537481835950670L, -9223372036854775808L, 9223372036854775807L };

    static float[] c = { 0f, 0f, Float.MAX_VALUE, 0.538284f, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, 0f, Float.MAX_VALUE, Float.POSITIVE_INFINITY };

    static float[] d = { Float.MAX_VALUE, Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY, 0.8563902f, 0f, 0.25173068f, Float.POSITIVE_INFINITY, 0.37455446f, Float.MIN_VALUE, Float.MIN_VALUE };

    long[] test_cp_neg(long[] a, long[] b, float[] c, float[] d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
            c[i] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3481().test_cp_neg(a, b, c, d);
    }
}
