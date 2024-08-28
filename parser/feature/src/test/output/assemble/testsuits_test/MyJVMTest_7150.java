public class MyJVMTest_7150 {

    static byte[] a = { 114, 103, 111, 56, -93, 84, 98, -112, -32, -16 };

    static byte[] b = { 67, -93, 28, 67, 7, 39, -128, -91, 115, -31 };

    static long[] c = { 0, -9223372036854775808L, -9095239060914961237L, 9223372036854775807L, 9223372036854775807L, -7870534498319833373L, 0, 0, -392911383621734102L, 0 };

    static long[] d = { 9223372036854775807L, -8951913044672719413L, 0, -3796777278456805379L, 9223372036854775807L, 9223372036854775807L, 9223372036854775807L, 6951066959531245222L, 0, 0 };

    static int ALIGN_OFF = 8;

    static int UNALIGN_OFF = 5;

    byte[] test_cp_unalndst(byte[] a, byte[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - UNALIGN_OFF; i += 1) {
            a[i + UNALIGN_OFF] = b[i];
            c[i + UNALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7150().test_cp_unalndst(a, b, c, d);
    }
}
