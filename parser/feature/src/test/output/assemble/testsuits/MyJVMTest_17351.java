public class MyJVMTest_17351 {

    static byte[] a = { -29, 92, -109, 121, 5, -111, 35, 37, 77, 0 };

    static byte[] b = { -52, -86, -111, -73, -105, -86, 34, 127, -44, -100 };

    static long[] c = { 5348532508403817780L, -2338922492664445518L, -262409097846659302L, 0, 5417177479105354420L, 0, 0, -9223372036854775808L, 9223372036854775807L, 0 };

    static long[] d = { 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, -9223372036854775808L, 0, 0 };

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
        new MyJVMTest_17351().test_cp_unalnsrc(a, b, c, d);
    }
}
