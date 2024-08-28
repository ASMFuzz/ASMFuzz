public class MyJVMTest_7605 {

    static long[] a = { -2167821256674702123L, 9223372036854775807L, 0, 813399077281746342L, -7103963068668551948L, 0, 9223372036854775807L, 9223372036854775807L, 0, -9223372036854775808L };

    static float[] b = { Float.POSITIVE_INFINITY, Float.MIN_VALUE, Float.MAX_VALUE, 0f, Float.NaN, 0f, Float.POSITIVE_INFINITY, 0.9469416f, Float.NEGATIVE_INFINITY, Float.MIN_VALUE };

    long[] test_ci(long[] a, float[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = -123;
            b[i] = -103.f;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7605().test_ci(a, b);
    }
}
