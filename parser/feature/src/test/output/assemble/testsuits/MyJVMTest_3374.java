public class MyJVMTest_3374 {

    static short[] a = { 0, -32768, 32767, -32768, 0, -32768, 32767, 0, -32768, -32768 };

    static long[] b = { -9223372036854775808L, -8641697128953377673L, 9223372036854775807L, -5448621145023271494L, 8856040353517866113L, 9223372036854775807L, 0, 185650355527883395L, -9223372036854775808L, -9223372036854775808L };

    short[] test_ci_neg(short[] a, long[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = -123;
            b[i] = -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3374().test_ci_neg(a, b);
    }
}
