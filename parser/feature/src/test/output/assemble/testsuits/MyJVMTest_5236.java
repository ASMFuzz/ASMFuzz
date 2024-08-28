public class MyJVMTest_5236 {

    static byte[] a = { 14, 67, -106, -114, 30, -85, -45, -23, -127, 82 };

    static byte[] b = { -57, -34, -79, -99, 117, 25, 77, 62, 62, -35 };

    static long[] c = { 0, 0, 9223372036854775807L, -89391062384470585L, 6687403569645956275L, -9223372036854775808L, 9223372036854775807L, 0, 9223372036854775807L, -9223372036854775808L };

    static long[] d = { -9223372036854775808L, 5685214323140621766L, 0, 7982091746972351300L, 9223372036854775807L, 0, -4141410051174736934L, 9223372036854775807L, -2940048834179202658L, 50667582990612972L };

    static int ALIGN_OFF = 8;

    byte[] test_cp_alndst(byte[] a, byte[] b, long[] c, long[] d) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i + ALIGN_OFF] = b[i];
            c[i + ALIGN_OFF] = d[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5236().test_cp_alndst(a, b, c, d);
    }
}
