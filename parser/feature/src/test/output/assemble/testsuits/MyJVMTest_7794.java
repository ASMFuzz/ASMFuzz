public class MyJVMTest_7794 {

    static byte[] a = { 11, -37, 60, -3, -76, -32, -41, -70, 92, 3 };

    static byte[] b = { 64, -21, -23, 76, 3, -106, -66, -5, 42, 70 };

    static long[] c = { -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, 9223372036854775807L, 2884092521411594210L, 9223372036854775807L, -9223372036854775808L, 0 };

    static long[] d = { 0, 9223372036854775807L, -5770938849482178437L, 2437954329937304095L, 0, -9223372036854775808L, 5197218788149523326L, -9223372036854775808L, -7128947563284593010L, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalnsrc(byte[] a, byte[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i] = b[i + UNALIGN_OFF];
            c[i] = d[i + UNALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7794().test_cp_unalnsrc(a, b, c, d);
    }
}
