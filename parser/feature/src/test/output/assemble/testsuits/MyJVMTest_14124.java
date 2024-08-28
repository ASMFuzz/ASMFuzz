public class MyJVMTest_14124 {

    static long[] a = { 9223372036854775807L, -9223372036854775808L, 7197276660033397321L, -9223372036854775808L, -7119198535975184318L, -111581164957778300L, 0, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L };

    static long b = -4491481265679660798L;

    long[] test_vi(long[] a, long b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14124().test_vi(a, b);
    }
}
