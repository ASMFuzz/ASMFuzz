public class MyJVMTest_6729 {

    static long[] a = { 0, -9223372036854775808L, 0, -9223372036854775808L, 9223372036854775807L, -6318666000484005125L, 9223372036854775807L, -9223372036854775808L, 9223372036854775807L, 0 };

    static float[] b = { 0f, Float.POSITIVE_INFINITY, 0f, Float.POSITIVE_INFINITY, 0f, Float.NaN, 0.40074372f, Float.NaN, Float.NEGATIVE_INFINITY, 0f };

    static long c = -8858428798381155958L;

    static float d = 0.55521137f;

    long[] test_vi(long[] a, float[] b, long c, float d) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6729().test_vi(a, b, c, d);
    }
}
