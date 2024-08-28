public class MyJVMTest_16231 {

    static byte[] a = { -119, 114, 78, -117, 29, -106, -26, -8, 1, -123 };

    static long[] b = { 0, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 6317210967184799660L, 0 };

    static byte c = 127;

    static long d = -9223372036854775808L;

    byte[] test_vi_neg(byte[] a, long[] b, byte c, long d) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16231().test_vi_neg(a, b, c, d);
    }
}
