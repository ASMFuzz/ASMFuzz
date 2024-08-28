public class MyJVMTest_14072 {

    static byte[] a = { 26, -97, -35, 98, -80, 15, -109, -88, -104, 75 };

    static byte[] b = { -59, -24, 26, -58, -5, 8, -119, 6, -118, 103 };

    static long[] c = { -4356234309154923047L, -8771772522281071871L, -9223372036854775808L, 0, 0, 0, -7273114560893948618L, 0, 9223372036854775807L, -5883272029358332570L };

    static long[] d = { 9223372036854775807L, 9223372036854775807L, -9223372036854775808L, 0, -5679134070822775676L, -9223372036854775808L, -9223372036854775808L, 9223372036854775807L, 0, -9223372036854775808L };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alnsrc(byte[] a, byte[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
            c[i] = d[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14072().test_cp_alnsrc(a, b, c, d);
    }
}
